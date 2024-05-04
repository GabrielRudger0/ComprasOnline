package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.PermissaoDTO;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.PermissaoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atualizarpermissao")
public class AtualizarPermissaoController {

    @Autowired
    PermissaoService permissaoService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping("/{id}")
    public String exibirAtualizarPermissao(Model model, @PathVariable Long id, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/login";
        }

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
