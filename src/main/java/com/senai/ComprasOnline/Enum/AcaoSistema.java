package com.senai.ComprasOnline.Enum;

public enum AcaoSistema {
    CADASTRO_PRODUTO("Botão de cadastro de produto"),
    CADASTRO_CATEGORIA("Botão de cadastro de categoria");

    private String descricao;

    AcaoSistema(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoAcao() {
        return descricao;
    }
}
