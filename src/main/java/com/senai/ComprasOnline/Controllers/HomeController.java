package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public String exbirHome(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        boolean loginaceito = usuarioService.existeUsuario(session.getAttribute("usuarioemail"));
        if (!loginaceito) {
            return "redirect:login";
        }

        return "home";

    }
}
