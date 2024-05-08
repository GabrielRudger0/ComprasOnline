package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.Services.CategoriaService;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.ProdutoService;
import com.senai.ComprasOnline.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    UsuarioService usuarioService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping("/{id}")
    public String exibirVisualizarProduto(Model model, @PathVariable Long id, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/";
        }

        HttpSession sessao = request.getSession();

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
    public String atualizarProduto(@ModelAttribute("produtoatualizado") ProdutoDTO produtoDTO, HttpServletRequest request){

        HttpSession sessao = request.getSession();

        String email = "";
        if (sessao.getAttribute("usuarioemail") != null) {
            email = sessao.getAttribute("usuarioemail").toString();
        }

        produtoDTO.setUsuarioEmail(email);

        produtoService.atualizarProduto(produtoDTO.getId(), produtoDTO);

        return "redirect:listaprodutos";
    }
}
