package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.CadastroDto;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class CadastrarUsuarioController {

    @Autowired
    ControleSessaoService controleSessao;
    
    @GetMapping("/cadastrarusuario")
    public String exibirListaUsuarios(Model model, HttpServletRequest request){

        CadastroDto cadastroDto = new CadastroDto();

        boolean usuarioInterno = false;
        if (controleSessao.validarUsuarioSessao(request).isEmpty()) {
            usuarioInterno = true;
        }

        model.addAttribute("usuarioInterno", usuarioInterno);
        model.addAttribute("usuarioDto", cadastroDto);
        
        return "cadastrarusuario";
    }
    
    
}
