package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Enum.AcaoSistema;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ListaUsuariosController {
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ControleSessaoService controleSessao;
    
    @GetMapping("/listausuarios")
    public String exibirListaUsuarios(Model model, HttpServletRequest request){

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/login";
        }

        boolean permVisualizarUsuario = controleSessao.validarUsuarioPermissao(request, AcaoSistema.VISUALIZAR_USUARIO);
        boolean permAtualizarUsuario  = controleSessao.validarUsuarioPermissao(request, AcaoSistema.ATUALIZAR_USUARIO);
        boolean permExcluirUsuario    = controleSessao.validarUsuarioPermissao(request, AcaoSistema.EXCLUIR_USUARIO);
        boolean permPermissaoUsuario  = controleSessao.validarUsuarioPermissao(request, AcaoSistema.PERMISSAO_USUARIO);
                     
        model.addAttribute("usuarios",usuarioService.obterListaUsuarios());
        model.addAttribute("permVisualizarUsuario",permVisualizarUsuario);
        model.addAttribute("permAtualizarUsuario",permAtualizarUsuario);
        model.addAttribute("permExcluirUsuario",permExcluirUsuario);
        model.addAttribute("permPermissaoUsuario",permPermissaoUsuario);

        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listausuarios";
    }
    
}
