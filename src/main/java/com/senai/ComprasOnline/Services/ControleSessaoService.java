package com.senai.ComprasOnline.Services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControleSessaoService {

    @Autowired
    UsuarioService usuarioService;

    public String validarUsuarioSessao(HttpServletRequest request) {
        HttpSession session = request.getSession();
        boolean loginaceito = usuarioService.existeUsuario(session.getAttribute("usuarioemail"));
        if (!loginaceito) {
            return "redirect:login";
        }
        return "";
    }

}
