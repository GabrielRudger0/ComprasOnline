package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.PermissaoDTO;
import com.senai.ComprasOnline.Services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atualizarpermissao")
public class AtualizarPermissaoController {

    @Autowired
    PermissaoService permissaoService;

    @GetMapping("/{id}")
    public String exibirAtualizarPermissao(Model model, @PathVariable Long id) {

        model.addAttribute("permissaoDTO", permissaoService.obterPermissao(id));
        model.addAttribute("acoes", permissaoService.obterAcoes());
        return "atualizarpermissao";
    }

    @PostMapping
    public String atualizarPermissao(@ModelAttribute("atualizarpermissao")PermissaoDTO permissaoDTO) {
        permissaoService.atualizarPermissao(permissaoDTO);
        return "redirect:listapermissoes";
    }
}
