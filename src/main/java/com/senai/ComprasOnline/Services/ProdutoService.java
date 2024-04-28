package com.senai.ComprasOnline.Services;

import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.Models.ProdutoModel;
import com.senai.ComprasOnline.Repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoDTO> obterListaProdutos() {
        List<ProdutoModel> listaProdutosModel = produtoRepository.findAll();

        if (listaProdutosModel.isEmpty()) {
            return new ArrayList<ProdutoDTO>();
        }

        return listaProdutosModel.stream().map(ProdutoDTO :: new).collect(Collectors.toList());

    }


}
