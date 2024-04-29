package com.senai.ComprasOnline.Models;

import com.senai.ComprasOnline.DTOs.LoginDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USUARIO")
@Data
public class UsuarioModel {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "email", nullable = false, length = 90)
    private String email;
    
    @Column(name = "senha", nullable = false, length = 90)
    private String senha;

    public UsuarioModel() {
    }

    public UsuarioModel(LoginDto login) {
        this.id     = login.getId();
        this.email  = login.getEmail();
        this.senha  = login.getSenha();
    }





}
