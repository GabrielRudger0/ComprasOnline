package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.CategoriaDTO;
import com.senai.ComprasOnline.Services.CategoriaService;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastrarcategoria")
public class CadastrarCategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping()
    public String exibirCadastrarCategoria(Model model, HttpServletRequest request) {
        model.addAttribute("categoriaDTO", new CategoriaDTO());

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/";
        }

        return "cadastrocategoria";
    }

    @PostMapping()
    public String cadastrarCategoria(@ModelAttribute("cadastroCategoria") CategoriaDTO categoriaDTO) {
        System.out.println(categoriaDTO.getDescricao());
        categoriaService.cadastrarCategoria(categoriaDTO);
        return "redirect:listacategorias";
    }

}
