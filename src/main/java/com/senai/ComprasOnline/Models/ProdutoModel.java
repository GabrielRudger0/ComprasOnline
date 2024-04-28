package com.senai.ComprasOnline.Models;

import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="PRODUTO")
@Data
public class ProdutoModel {

    @Id
    @Column(name = "ProdutoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ProdutoDescricao")
    private String descricao;

    @Column(name = "ProdutoCategoria")
    private String categoria;

    @Column(name = "ProdutoAtivo")
    private Boolean ativo;

    @Column(name = "ProdutoValor")
    private Double valor;

    public ProdutoModel() {
    }

    public ProdutoModel(ProdutoDTO produtoDTO) {
        this.descricao = produtoDTO.getDescricao();
        this.categoria = produtoDTO.getCategoria();
        this.ativo     = produtoDTO.getAtivo();
        this.valor     = produtoDTO.getValor();
    }

    public ProdutoModel(Long id, ProdutoDTO produtoDTO) {
        this.id        = id;
        this.descricao = produtoDTO.getDescricao();
        this.categoria = produtoDTO.getCategoria();
        this.ativo     = produtoDTO.getAtivo();
        this.valor     = produtoDTO.getValor();
    }
}
