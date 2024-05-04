package com.senai.ComprasOnline.Services;

import com.senai.ComprasOnline.DTOs.ComplexUsuarioDTO;
import com.senai.ComprasOnline.DTOs.PermissaoDTO;
import com.senai.ComprasOnline.Enum.AcaoSistema;
import com.senai.ComprasOnline.Models.PermissaoModel;
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

    public boolean validarUsuarioPermissao(HttpServletRequest request, AcaoSistema acao) {
        HttpSession session = request.getSession();

        ComplexUsuarioDTO usuario = usuarioService.buscarUsuarioPorEmail(session.getAttribute("usuarioemail").toString());

        for (PermissaoModel permissoesUsuario : usuario.getPermissoes()) {
            if (permissoesUsuario.getAcao() == acao.ordinal()) {
                return true;
            }
        }

        return false;
    }

}
