package com.senai.ComprasOnline.Services;

import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.DTOs.VisualizarProdutoDTO;
import com.senai.ComprasOnline.Models.ProdutoModel;
import com.senai.ComprasOnline.Repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<VisualizarProdutoDTO> obterListaProdutos() {
        List<ProdutoModel> listaProdutosModel = produtoRepository.findAll();

        if (listaProdutosModel.isEmpty()) {
            return new ArrayList<VisualizarProdutoDTO>();
        }

        return converterListaProdutosVisual(listaProdutosModel);

    }

    public List<VisualizarProdutoDTO> converterListaProdutosVisual(List<ProdutoModel> listaProdutosModel) {
        return listaProdutosModel.stream().map(VisualizarProdutoDTO:: new).collect(Collectors.toList());
    }

    public boolean inserirProduto(ProdutoDTO produto) {
        produtoRepository.save(new ProdutoModel(produto));
        return true;
    }

    public boolean excluirProduto(Long id) {

        produtoRepository.deleteById(id);
        return true;
    }

    public ProdutoDTO obterProduto(Long id) {
        Optional<ProdutoModel> produtoBD = produtoRepository.findById(id);
        if(!produtoBD.isPresent()) {
            return null;
        }

        return new ProdutoDTO(produtoBD.get());
    }

    public boolean atualizarProduto(Long id, ProdutoDTO produto) {
        produtoRepository.save(new ProdutoModel(id, produto));
        return true;
    }

    public List<VisualizarProdutoDTO> buscarProduto(String produtoDescricao) {
        List<ProdutoModel> listaProdutosModel = produtoRepository.findByDescricaoContaining(produtoDescricao);

        if(listaProdutosModel.isEmpty()) {
            return new ArrayList<VisualizarProdutoDTO>();
        }

        return converterListaProdutosVisual(listaProdutosModel);
    }


}
