package com.senai.ComprasOnline.Services;

import com.senai.ComprasOnline.DTOs.AcaoDTO;
import com.senai.ComprasOnline.DTOs.PermissaoDTO;
import com.senai.ComprasOnline.Enum.AcaoSistema;
import com.senai.ComprasOnline.Models.PermissaoModel;
import com.senai.ComprasOnline.Repositorys.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissaoService {

    @Autowired
    PermissaoRepository permissaoRepository;

    public List<PermissaoDTO> buscarPermissoes() {
        List<PermissaoModel> permissoes = permissaoRepository.findAll();

        //Remove a permissão de adm
        permissoes.removeIf(permissao -> permissao.getAcao() == AcaoSistema.USUARIO_ADM.ordinal());

        if (permissoes.isEmpty()) {
            return new ArrayList<>();
        }

        return converterListaPermissoes(permissoes);
    }

    public void cadastrarPermissao(PermissaoDTO permissao) {
        permissaoRepository.save(new PermissaoModel(permissao));
    }

    public PermissaoDTO obterPermissao(Long id) {
        return new PermissaoDTO(permissaoRepository.findById(id).get());
    }

    public void excluirProduto(Long id) {
        permissaoRepository.delete(permissaoRepository.findById(id).get());
    }

    public void atualizarPermissao(PermissaoDTO permissaoDTO) {
        permissaoRepository.save(new PermissaoModel(permissaoDTO.getId(), permissaoDTO));
    }

    public List<AcaoDTO> obterAcoes() {
        List<AcaoDTO> acoes = new ArrayList<>();

        for (AcaoSistema acao : AcaoSistema.values()) {
            AcaoDTO acaoDTO = new AcaoDTO();
            acaoDTO.setNum(acao.ordinal());
            acaoDTO.setDescricaoAcao(acao.getDescricaoAcao());

            acoes.add(acaoDTO);
        }

        return acoes;

    }

    public String injetarPermissoesSistema() {

        if (AcaoSistema.values().length == 0) {
            return "Nenhuma ação do sistema inserida";
        }

        int count = 0;

        for (AcaoSistema acao : AcaoSistema.values()) {
            if(!permissaoRepository.existsByAcao(acao.ordinal())) {
                permissaoRepository.save(new PermissaoModel(acao.getDescricaoAcao(), acao.ordinal()));
                count++;
            }
        }

        if (count == 0) {
            return "Nenhuma nova permissão do sistema precisou ser inserida.";
        }

        if (count == 1) {
            return count + " nova permissão do sistema foi inserida com sucesso!";
        }
        return count + " novas permissões do sistema foram inseridas com sucesso!";
    }

    private List<PermissaoDTO> converterListaPermissoes(List<PermissaoModel> permissoesModel) {
        return permissoesModel.stream().map(PermissaoDTO::new).collect(Collectors.toList());
    }
}
