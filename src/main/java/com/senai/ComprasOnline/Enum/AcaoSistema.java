package com.senai.ComprasOnline.Enum;

public enum AcaoSistema {
    CADASTRO_PRODUTO("Botão de CADASTRO de produto"),
    VISUALIZAR_PRODUTO("Botão de VISUALIZAR produto"),
    ATUALIZAR_PRODUTO("Botão de ATUALIZAR produto"),
    EXCLUIR_PRODUTO("Botão de EXCLUIR produto"),

    CADASTRO_CATEGORIA("Botão de CADASTRO de categoria"),
    ATUALIZAR_CATEGORIA("Botão de ATUALIZAR categoria"),
    EXCLUIR_CATEGORIA("Botão de EXCLUIR categoria"),

    VISUALIZAR_USUARIO("Botão de VISUALIZAR USUARIO"),
    ATUALIZAR_USUARIO("Botão de ATUALIZAR USUARIO"),
    EXCLUIR_USUARIO("Botão de EXCLUIR USUARIO"),
    PERMISSAO_USUARIO("Botão de PERMISSOES do  USUARIO"),

    USUARIO_ADM("Todas as permissões");

    private String descricao;

    AcaoSistema(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoAcao() {
        return descricao;
    }
}
