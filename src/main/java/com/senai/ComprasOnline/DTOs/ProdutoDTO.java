package com.senai.ComprasOnline.DTOs;

import com.senai.ComprasOnline.Models.CategoriaModel;
import com.senai.ComprasOnline.Models.ProdutoModel;
import com.senai.ComprasOnline.Models.UsuarioModel;
import lombok.Data;

@Data
public class ProdutoDTO {

    private Long id;

    private String descricao;

    private CategoriaModel categoria;

    private Boolean ativo;

    private Double valor;

    private String usuarioEmail;

    public ProdutoDTO(ProdutoModel produtoModel) {
        this.id        = produtoModel.getId();
        this.descricao = produtoModel.getDescricao();
        this.categoria = produtoModel.getCategoria();
        this.ativo     = produtoModel.getAtivo();
        this.valor     = produtoModel.getValor();
        this.usuarioEmail   = produtoModel.getUsuario().getEmail();
    }

    public ProdutoDTO() {

    }
}
