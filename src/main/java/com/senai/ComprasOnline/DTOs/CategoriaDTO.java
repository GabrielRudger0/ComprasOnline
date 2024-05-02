package com.senai.ComprasOnline.DTOs;

import com.senai.ComprasOnline.Models.CategoriaModel;
import lombok.Data;

@Data
public class CategoriaDTO {

    private Long id;

    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(CategoriaModel categoriaModel) {
        this.id = categoriaModel.getId();
        this.descricao = categoriaModel.getDescricao();
    }
}
