package com.senai.ComprasOnline.Services;

import com.senai.ComprasOnline.DTOs.PermissaoDTO;
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
        if (permissoes.isEmpty()) {
            return new ArrayList<>();
        }

        return converterListaPermissoes(permissoes);
    }

    private List<PermissaoDTO> converterListaPermissoes(List<PermissaoModel> permissoesModel) {
        return permissoesModel.stream().map(PermissaoDTO::new).collect(Collectors.toList());
    }
}
