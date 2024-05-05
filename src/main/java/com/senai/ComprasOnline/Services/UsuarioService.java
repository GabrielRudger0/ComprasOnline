/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.ComprasOnline.Services;

import com.senai.ComprasOnline.DTOs.*;
import com.senai.ComprasOnline.Enum.AcaoSistema;
import com.senai.ComprasOnline.Models.PermissaoModel;
import com.senai.ComprasOnline.Models.UsuarioModel;
import com.senai.ComprasOnline.Repositorys.PermissaoRepository;
import com.senai.ComprasOnline.Repositorys.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PermissaoRepository permissaoRepository;
        
    public boolean validarLogin(LoginDto loginDto){
              
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findByEmail(loginDto.getEmail());
        
        //--Verifica se achou o usuário no banco de dados pelo Email
        if (!optionalUsuario.isPresent()){
            //--Se não achou retorna erro
            return false;
        }
        
        //--Se achou o usuário pelo e-mail verifica se a senha esta correta!
        if (!optionalUsuario.get().getSenha().equals(loginDto.getSenha())){
            //--Se não esta correta retorna erro
            return false;
        }        
        
        return true;
    }
    
    public List<UsuarioDto> obterListaUsuarios(){
        
        List<UsuarioModel> listaUsuarioModel = usuarioRepository.findAll();

        //Remove admin da tela (não pode ser alterado, excluido);
        listaUsuarioModel.removeIf(usuario -> usuario.getEmail().equals("admin"));
        
        List<UsuarioDto> listaUsuario = new ArrayList();
        
        for (UsuarioModel usuario : listaUsuarioModel){
            
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId() );
            usuarioDto.setEmail(usuario.getEmail());
            
            listaUsuario.add(usuarioDto);
        }
        
        return listaUsuario;
        
    }
    
    public boolean cadastrarUsuario(CadastroDto cadastro){
        
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findByEmail(cadastro.getEmail());
        
        if (optionalUsuario.isPresent()){
            return false;
        }
        
        UsuarioModel usuario = new UsuarioModel();
        usuario.setEmail(cadastro.getEmail());
        usuario.setSenha(cadastro.getSenha());
        
        usuarioRepository.save(usuario);
        
        return true;
    }

    public boolean atualizarUsuario(LoginDto usuario) {

        usuarioRepository.save(new UsuarioModel(usuario));

        return true;
    }
    
    public boolean excluirUsuario(Long id){
        
        System.out.println("id:" + id);
        
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        
        if (!optionalUsuario.isPresent()){
            return false;
        }
        
        usuarioRepository.delete(optionalUsuario.get());
        
        return true;
        
    }
    
    public UsuarioDto obterUsuario(Long id){
        
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        
        UsuarioDto usuarioDto = new UsuarioDto();
        
        if (!optionalUsuario.isPresent()){            
            usuarioDto.setId(0L);
            return usuarioDto;
        }
        
        usuarioDto.setId(optionalUsuario.get().getId());
        usuarioDto.setEmail(optionalUsuario.get().getEmail());        
        
        return usuarioDto;
    }

    public LoginDto obterLoginDto(Long id) {
        Optional<UsuarioModel> optionalLogin = usuarioRepository.findById(id);

        LoginDto LoginDto = new LoginDto();

        if (!optionalLogin.isPresent()){
            LoginDto.setId(0L);
            return LoginDto;
        }

        LoginDto.setId(optionalLogin.get().getId());
        LoginDto.setEmail(optionalLogin.get().getEmail());
        LoginDto.setSenha(optionalLogin.get().getSenha());

        return LoginDto;

    }

    public List<PermissaoDTO> buscarPermissoesUsuario(Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        List<PermissaoModel> permissoesUsuarioModel = usuario.get().getPermissoes();

        if(!permissoesUsuarioModel.isEmpty()) {
            return permissoesUsuarioModel.stream().map(PermissaoDTO::new).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public ComplexUsuarioDTO buscarUsuarioPorEmail(String email) {
        return new ComplexUsuarioDTO(usuarioRepository.findByEmail(email).get());
    }

    public void inserirPermissao(UsuarioDto usuario) {
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(usuario.getId());

        if (usuarioModel.isPresent()) {
            UsuarioModel usuarioComNovaPermissao = usuarioModel.get();

            PermissaoModel permissao = permissaoRepository.findById(Long.parseLong(usuario.getPermissao())).get();

            usuarioComNovaPermissao.getPermissoes().add(permissao);

            usuarioRepository.save(usuarioComNovaPermissao);

        }
    }
    public boolean existeUsuario(Object email) {
        if (email != null) {
            String usuarioemail = email.toString();
            Optional<UsuarioModel> usuariobd = usuarioRepository.findByEmail(usuarioemail);
            return usuariobd.isPresent();
        }
        return false;
    }

    public void excluirUsuarioPermissao(Long usuarioId, Long permissaoId) {
        UsuarioModel usuario = usuarioRepository.findById(usuarioId).get();
        List<PermissaoModel> permissoesUsuario = usuario.getPermissoes();

        permissoesUsuario.remove(permissaoRepository.findById(permissaoId).get());
        usuario.setPermissoes(permissoesUsuario);

        usuarioRepository.save(usuario);

    }

    public boolean verificarExisteUsuarioADM() {
        return usuarioRepository.existsByEmail("admin");
    }

    public void criarUsuarioADM() {
        UsuarioModel usuarioADM = new UsuarioModel();

        usuarioADM.setEmail("admin");
        usuarioADM.setSenha("123");
        List<PermissaoModel> permissoes = permissaoRepository.findAll();
        if (permissoes.isEmpty()) {
            usuarioADM.setPermissoes(new ArrayList<>());
        } else {
            usuarioADM.setPermissoes(permissoes);
        }

        usuarioRepository.save(usuarioADM);
    }
}
