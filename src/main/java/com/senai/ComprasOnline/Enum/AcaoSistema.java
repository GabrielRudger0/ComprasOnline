package com.senai.ComprasOnline.Enum;

public enum AcaoSistema {


    /* NÃO ALTERE OS ITENS JÁ PRESENTES */
    /*  APENAS INSIRA NOVAS PERMISSÕES  */

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

    USUARIO_ADM("ADMIN");

    private String descricao;

    AcaoSistema(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoAcao() {
        return descricao;
    }
    public static String getDescricaoByOrdinal(int ordinal) {
        for (AcaoSistema acaoSistema : AcaoSistema.values()) {
            if (acaoSistema.ordinal() == ordinal) {
                return acaoSistema.getDescricaoAcao();
            }
        }
        return null;
    }
}
