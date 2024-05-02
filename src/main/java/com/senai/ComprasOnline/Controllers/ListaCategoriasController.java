package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listacategorias")
public class ListaCategoriasController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public String exibirListaCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.obterCategorias());
        return "listacategorias";
    }


}
