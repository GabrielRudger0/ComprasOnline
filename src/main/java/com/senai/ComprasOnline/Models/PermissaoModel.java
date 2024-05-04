package com.senai.ComprasOnline.Models;

import com.senai.ComprasOnline.DTOs.PermissaoDTO;
import com.senai.ComprasOnline.Enum.AcaoSistema;
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

    @Column(name = "permissaoAcao")
    private Integer acao;

    public PermissaoModel() {
    }

    public PermissaoModel(PermissaoDTO permissaoDTO) {
        this.descricao = permissaoDTO.getDescricao();
        this.acao      = permissaoDTO.getAcao();
    }
    public PermissaoModel(Long id, PermissaoDTO permissaoDTO) {
        this.id = id;
        this.descricao = permissaoDTO.getDescricao();
        this.acao      = permissaoDTO.getAcao();
    }
}
