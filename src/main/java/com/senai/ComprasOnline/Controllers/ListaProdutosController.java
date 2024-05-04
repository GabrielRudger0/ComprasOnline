package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.BuscarProdutoDTO;
import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.ProdutoService;
import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping()
    public String exibirListaProdutos(Model model, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/login";
        }

        boolean permCadastroProduto = false;

        model.addAttribute("buscarProdutoDTO", new BuscarProdutoDTO(""));
        model.addAttribute("produtos", produtoService.obterListaProdutos());
        model.addAttribute("permCadastroProduto", permCadastroProduto);
        return "listaprodutos";
    }

    @PostMapping()
    public String buscarProduto(Model model, @ModelAttribute("buscarProdutoDTO") BuscarProdutoDTO buscarProdutoDTO){

        model.addAttribute("produtos", produtoService.buscarProduto(buscarProdutoDTO.getItemBusca()));

        return "listaprodutos";
    }


}
