package com.senai.ComprasOnline.Models;

import com.senai.ComprasOnline.DTOs.CategoriaDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CATEGORIA")
@Data
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoriaId")
    private Long id;

    @Column(name = "CategoriaDescricao")
    private String descricao;

    public CategoriaModel() {
    }

    public CategoriaModel(CategoriaDTO categoriaDTO) {
        this.descricao = categoriaDTO.getDescricao();
    }
}
