package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.DTOs.VisualizarProdutoDTO;
import com.senai.ComprasOnline.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizarproduto")
public class VisualizarProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/{id}")
    public String exibirVisualizarProduto(Model model, @PathVariable Long id) {
        ProdutoDTO produtoDTO = produtoService.obterProduto(id);
        if (produtoDTO == null) {
            System.out.println("deu erro");
            return "visualizarproduto";
        }

        model.addAttribute("visualizarProdutoDTO", new VisualizarProdutoDTO(produtoDTO));
        return "visualizarproduto";
    }
}
