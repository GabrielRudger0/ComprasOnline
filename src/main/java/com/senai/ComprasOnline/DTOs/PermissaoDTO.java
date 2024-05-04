package com.senai.ComprasOnline.DTOs;

import com.senai.ComprasOnline.Models.PermissaoModel;
import lombok.Data;

@Data
public class PermissaoDTO {

    private Long id;

    private String descricao;

    public PermissaoDTO() {
    }

    public PermissaoDTO(PermissaoModel permissaoModel) {
        this.id = permissaoModel.getId();
        this.descricao = permissaoModel.getDescricao();
    }
}
