package com.senai.ComprasOnline.Models;

import com.senai.ComprasOnline.DTOs.ComplexUsuarioDTO;
import com.senai.ComprasOnline.DTOs.LoginDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToMany
    @Column(name = "permissoes")
    private List<PermissaoModel> permissoes;

    public UsuarioModel() {
    }

    public UsuarioModel(LoginDto login) {
        this.id     = login.getId();
        this.email  = login.getEmail();
        this.senha  = login.getSenha();
    }



}
