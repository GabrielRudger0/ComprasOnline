package com.senai.ComprasOnline.DTOs;

import com.senai.ComprasOnline.Models.CategoriaModel;
import com.senai.ComprasOnline.Models.ProdutoModel;
import lombok.Data;

@Data
public class ProdutoDTO {

    private Long id;

    private String descricao;

    private CategoriaModel categoria;

    private Boolean ativo;

    private Double valor;

    public ProdutoDTO(ProdutoModel produtoModel) {
        this.id        = produtoModel.getId();
        this.descricao = produtoModel.getDescricao();
        this.categoria = produtoModel.getCategoria();
        this.ativo     = produtoModel.getAtivo();
        this.valor     = produtoModel.getValor();
    }

    public ProdutoDTO() {

    }
}
