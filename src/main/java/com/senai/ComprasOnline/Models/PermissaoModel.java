package com.senai.ComprasOnline.Models;

import com.senai.ComprasOnline.DTOs.PermissaoDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="PERMISSAO")
@Data
public class PermissaoModel {

    @Id
    @Column(name = "permissaoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permissaoDescricao")
    private String descricao;

    public PermissaoModel() {
    }

    public PermissaoModel(PermissaoDTO permissaoDTO) {
        this.descricao = permissaoDTO.getDescricao();
    }
}
