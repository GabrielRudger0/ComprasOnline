package com.senai.ComprasOnline.Models;

import com.senai.ComprasOnline.DTOs.ComplexUsuarioDTO;
import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.DTOs.UsuarioDto;
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

/*    @Column(name = "ProdutoCategoria")
    private String categoria;
    */

    @ManyToOne
    private CategoriaModel categoria;

    @Column(name = "ProdutoAtivo")
    private Boolean ativo;

    @Column(name = "ProdutoValor")
    private Double valor;

    @ManyToOne
    private UsuarioModel usuario;

    public ProdutoModel() {
    }

    public ProdutoModel(ProdutoDTO produtoDTO, UsuarioModel usuarioInclusao) {
        this.descricao = produtoDTO.getDescricao();
        this.categoria = produtoDTO.getCategoria();
        this.ativo     = produtoDTO.getAtivo();
        this.valor     = produtoDTO.getValor();
        this.usuario   = usuarioInclusao;
    }

    public ProdutoModel(Long id, ProdutoDTO produtoDTO, UsuarioModel usuarioInclusao) {
        this.id        = id;
        this.descricao = produtoDTO.getDescricao();
        this.categoria = produtoDTO.getCategoria();
        this.ativo     = produtoDTO.getAtivo();
        this.valor     = produtoDTO.getValor();
        this.usuario   = usuarioInclusao;
    }
}
