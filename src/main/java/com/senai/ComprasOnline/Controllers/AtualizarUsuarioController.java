package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.LoginDto;
import com.senai.ComprasOnline.DTOs.UsuarioDto;
import com.senai.ComprasOnline.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atualizarusuario")
public class AtualizarUsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{id}")
    public String exibirAtualizarProduto(Model model, @PathVariable Long id) {
        LoginDto loginDto = usuarioService.obterLoginDto(id);
        if (loginDto == null) {
            return "atualizarusuario";
        }

        model.addAttribute("loginDto", loginDto);
        return "atualizarusuario";
    }

    @PostMapping()
    public String atualizarUsuario(@ModelAttribute("atualizaUsuario") LoginDto loginDto) {

        usuarioService.atualizarUsuario(loginDto);
        return "redirect:listausuarios";
    }
}
