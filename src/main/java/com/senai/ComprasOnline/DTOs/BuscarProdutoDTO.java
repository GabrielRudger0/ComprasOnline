package com.senai.ComprasOnline.DTOs;

import lombok.Data;

@Data
public class BuscarProdutoDTO {

    private String itemBusca;

    public BuscarProdutoDTO() {
    }

    public BuscarProdutoDTO(String itemBusca) {
        this.itemBusca = itemBusca;
    }
}
