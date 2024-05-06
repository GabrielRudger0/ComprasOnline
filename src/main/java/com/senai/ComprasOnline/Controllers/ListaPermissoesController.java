package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.PermissaoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listapermissoes")
public class ListaPermissoesController {

    @Autowired
    PermissaoService permissaoService;

    @Autowired
    ControleSessaoService controleSessao;


    @GetMapping
    public String exibirListaPermissoes(Model model, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("permissoes", permissaoService.buscarPermissoes());

        return "listapermissoes";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPermissao(@PathVariable Long id){

        permissaoService.excluirProduto(id);
        return ResponseEntity.ok("Permissão excluída com sucesso.");

    }

}
