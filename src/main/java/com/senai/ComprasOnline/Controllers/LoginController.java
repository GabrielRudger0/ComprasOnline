package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.LoginDto;
import com.senai.ComprasOnline.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class LoginController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String exibirLogin(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();

        session.removeAttribute("usuarioemail");

        System.out.println("usuarioemail = " + session.getAttribute("usuarioemail"));

        LoginDto loginDto = new LoginDto();
        
        model.addAttribute("loginDto", loginDto);
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "login";
    }
    
    @PostMapping("/login")
    public String realizarLogin(@ModelAttribute("loginDto") LoginDto loginDto, HttpServletRequest request){
        
        //--Chamar método da classe UsuarioService passando por parâmetro o Dto
        boolean acesso = usuarioService.validarLogin(loginDto);
        
        if(acesso){
            HttpSession session = request.getSession();
            session.setAttribute("usuarioemail", loginDto.getEmail());

             System.out.println("usuarioemail = " + session.getAttribute("usuarioemail"));

            return "redirect:home";
        }
        
        return "redirect:login?erro";
        
    } 
        
    @PostMapping("/logout")
    public String realizarLogout(Model model){
        return "redirect:/?logout";
    }
}
