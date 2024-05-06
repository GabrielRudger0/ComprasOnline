package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.CategoriaDTO;
import com.senai.ComprasOnline.Services.CategoriaService;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atualizarcategoria")
public class AtualizarCategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping("/{id}")
    public String exibirAtualizarCategoria(Model model, @PathVariable Long id, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("categoriaDTO", categoriaService.buscarCategoria(id));

        return "atualizarcategoria";
    }

    @PostMapping()
    public String atualizarCategoria(@ModelAttribute("atualizarcategoria") CategoriaDTO categoriaDTO) {
        categoriaService.atualizarCategoria(categoriaDTO);
        return "redirect:/listacategorias";
    }

}
