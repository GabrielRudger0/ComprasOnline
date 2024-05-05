package com.senai.ComprasOnline.Enum;

public enum AcaoSistema {
    CADASTRO_PRODUTO("Botão de cadastro de produto"),
    VISUALIZAR_PRODUTO("Botão de visualizar produto"),
    ATUALIZAR_PRODUTO("Botão de atualizar produto"),
    EXCLUIR_PRODUTO("Botão de excluir produto"),

    CADASTRO_CATEGORIA("Botão de cadastro de categoria"),
    ATUALIZAR_CATEGORIA("Botão de atualizar categoria");

    private String descricao;

    AcaoSistema(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoAcao() {
        return descricao;
    }
}
