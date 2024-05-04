package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listapermissoes")
public class ListaPermissoesController {

    @Autowired
    PermissaoService permissaoService;

    @GetMapping
    public String exibirListaPermissoes(Model model) {

        model.addAttribute("permissoes", permissaoService.buscarPermissoes());

        return "listapermissoes";
    }

}
