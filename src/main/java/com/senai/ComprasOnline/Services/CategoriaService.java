package com.senai.ComprasOnline.Services;

import com.senai.ComprasOnline.DTOs.CategoriaDTO;
import com.senai.ComprasOnline.Models.CategoriaModel;
import com.senai.ComprasOnline.Repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> obterCategorias() {

        return converterListaCategoria(categoriaRepository.findAll());
    }

    public void cadastrarCategoria(CategoriaDTO categoria) {
        categoriaRepository.save(new CategoriaModel(categoria));
    }

    private List<CategoriaDTO> converterListaCategoria(List<CategoriaModel> listaCategoriaModel) {
        return listaCategoriaModel.stream().map(CategoriaDTO ::new).collect(Collectors.toList());
    }

}