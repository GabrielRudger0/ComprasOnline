package com.senai.ComprasOnline.DTOs;

import com.senai.ComprasOnline.Models.PermissaoModel;
import com.senai.ComprasOnline.Models.UsuarioModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ComplexUsuarioDTO {

    private Long id;

    private String email;

    private List<PermissaoModel> permissoes;

    public ComplexUsuarioDTO() {
    }

    public ComplexUsuarioDTO(UsuarioModel usuarioBD) {
        this.id = usuarioBD.getId();
        this.email = usuarioBD.getEmail();
        this.permissoes = usuarioBD.getPermissoes();
    }
}
