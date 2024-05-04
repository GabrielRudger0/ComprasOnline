package com.senai.ComprasOnline.Models;

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


}
