package com.senai.ComprasOnline.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
    
    private Long id;
    
    private String email;

    private String permissao;

    public UsuarioDto() {
    }
}
