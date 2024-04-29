package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.CadastroDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class CadastrarUsuarioController {
   
    
    @GetMapping("/cadastrarusuario")
    public String exibirListaUsuarios(Model model){
        
        CadastroDto cadastroDto = new CadastroDto();
        
        model.addAttribute("usuarioDto", cadastroDto);
        
        return "cadastrarusuario";
    }
    
    
}
