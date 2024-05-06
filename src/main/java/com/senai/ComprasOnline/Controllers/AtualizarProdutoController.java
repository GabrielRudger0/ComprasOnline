package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.Services.CategoriaService;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.ProdutoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atualizarproduto")
public class AtualizarProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping("/{id}")
    public String exibirVisualizarProduto(Model model, @PathVariable Long id, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/";
        }

        ProdutoDTO produtoDTO = produtoService.obterProduto(id);
        if (produtoDTO == null) {
            System.out.println("deu erro");
            return "atualizarproduto";
        }

        model.addAttribute("produtoDTO", produtoDTO);
        model.addAttribute("categorias", categoriaService.obterCategorias());
        return "atualizarproduto";
    }

    @PostMapping()
    public String atualizarProduto(@ModelAttribute("produtoatualizado") ProdutoDTO produtoDTO){


        produtoService.atualizarProduto(produtoDTO.getId(), produtoDTO);
        System.out.println(produtoDTO.getId());

        return "redirect:listaprodutos";
    }
}
