package com.senai.ComprasOnline.DTOs;

import com.senai.ComprasOnline.Enum.AcaoSistema;
import lombok.Data;

@Data
public class AcaoDTO {

    private Integer num;

    private String descricaoAcao;

    public AcaoDTO() {
    }

    public AcaoDTO(AcaoSistema acao) {
        this.num = acao.ordinal();
        this.descricaoAcao = getDescricaoAcao();
    }
}
