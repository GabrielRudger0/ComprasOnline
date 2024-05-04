package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.PermissaoDTO;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.PermissaoService;
import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping()
    public String exibirCadastrarPermissao(Model model, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/login";
        }

        model.addAttribute("permissaoDTO", new PermissaoDTO());
        model.addAttribute("acoes", permissaoService.obterAcoes());

        return "cadastropermissao";
    }

    @PostMapping()
    public String cadastrarPermissao(@ModelAttribute ("cadastrarPermissao") PermissaoDTO permissao){

        permissaoService.cadastrarPermissao(permissao);

        return "redirect:listapermissoes";
    }
}
