package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.PermissaoDTO;
import com.senai.ComprasOnline.Services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastrarpermissao")
public class CadastrarPermissaoController {

    @Autowired
    PermissaoService permissaoService;

    @GetMapping()
    public String exibirCadastrarPermissao(Model model) {

        model.addAttribute("permissaoDTO", new PermissaoDTO());

        return "cadastropermissao";
    }

    @PostMapping()
    public String cadastrarPermissao(@ModelAttribute ("cadastrarPermissao") PermissaoDTO permissao){

        permissaoService.cadastrarPermissao(permissao);

        return "redirect:listapermissoes";
    }
}
