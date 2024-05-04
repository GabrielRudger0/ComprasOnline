package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.UsuarioDto;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.PermissaoService;
import com.senai.ComprasOnline.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/listapermissoesusuario")
public class ListaPermissoesUsuarioController {

    @Autowired
    PermissaoService permissaoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping("/{id}")
    public String exibirPermissoesUsuario(Model model, @PathVariable Long id, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/login";
        }

        model.addAttribute("usuarioDTO", usuarioService.obterUsuario(id));
        model.addAttribute("combopermissoes", permissaoService.buscarPermissoes());
        model.addAttribute("permissoes", usuarioService.buscarPermissoesUsuario(id));

        return "listapermissoesusuario";
    }

    @PostMapping()
    public String inserirPermissaoUsuario(Model model, @ModelAttribute("usuarioDTO") UsuarioDto usuario) {

        usuarioService.inserirPermissao(usuario);
        return "redirect:listapermissoesusuario/" + usuario.getId();
    }
}
