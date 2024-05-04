package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ListaUsuariosController {
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ControleSessaoService controleSessao;
    
    @GetMapping("/listausuarios")
    public String exibirListaUsuarios(Model model, HttpServletRequest request){

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/login";
        }
                     
        model.addAttribute("usuarios",usuarioService.obterListaUsuarios());
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listausuarios";
    }
    
}
