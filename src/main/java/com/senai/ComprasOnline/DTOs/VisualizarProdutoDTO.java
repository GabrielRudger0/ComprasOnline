package com.senai.ComprasOnline.DTOs;


import com.senai.ComprasOnline.Models.ProdutoModel;
import lombok.Data;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Data
public class VisualizarProdutoDTO {
    private Long id;

    private String descricao;

    private String categoria;

    private String ativo;

    private String valor;

    public VisualizarProdutoDTO() {
    }

    public VisualizarProdutoDTO(ProdutoModel produtoDTO) {
        this.id = produtoDTO.getId();
        this.descricao = produtoDTO.getDescricao();
        this.categoria = produtoDTO.getCategoria().getDescricao();
        this.ativo = converterAtivo(produtoDTO.getAtivo());
        this.valor = formatToBrazilianReal(produtoDTO.getValor());
    }

    private static String formatToBrazilianReal(Double value) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(locale);
        DecimalFormat decimalFormatter = (DecimalFormat) numberFormatter;
        decimalFormatter.setGroupingUsed(true); // Enable thousands separators
        decimalFormatter.setGroupingSize(3); // Set thousands separator group size to 3
        decimalFormatter.setMinimumFractionDigits(2); // Set minimum decimal places to 2
        decimalFormatter.setMaximumFractionDigits(2); // Set maximum decimal places to 2
        return decimalFormatter.format(value);
    }

    private String converterAtivo(boolean ativo) {
        if (ativo) {
            return "Sim";
        }
        return "Não";
    }
}
