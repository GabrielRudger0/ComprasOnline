package com.senai.ComprasOnline.Models;

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

}
