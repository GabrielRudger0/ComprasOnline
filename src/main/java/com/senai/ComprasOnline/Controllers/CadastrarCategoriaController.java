package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.CategoriaDTO;
import com.senai.ComprasOnline.Services.CategoriaService;
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

    @GetMapping()
    public String exibirCadastrarCategoria(Model model) {
        model.addAttribute("categoriaDTO", new CategoriaDTO());

        return "cadastrocategoria";
    }

    @PostMapping()
    public String cadastrarCategoria(@ModelAttribute("cadastroCategoria") CategoriaDTO categoriaDTO) {
        System.out.println(categoriaDTO.getDescricao());
        categoriaService.cadastrarCategoria(categoriaDTO);
        return "redirect:listacategorias";
    }

}
