package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.BuscarProdutoDTO;
import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listaprodutos")
public class ListaProdutosController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping()
    public String exibirListaProdutos(Model model) {

        model.addAttribute("produtos", produtoService.obterListaProdutos());
        return "listaprodutos";
    }

    @PostMapping()
    public String atualizarProduto(@ModelAttribute("buscarproduto") BuscarProdutoDTO buscarProdutoDTO){
        return "redirect:listaprodutos";
    }


}
