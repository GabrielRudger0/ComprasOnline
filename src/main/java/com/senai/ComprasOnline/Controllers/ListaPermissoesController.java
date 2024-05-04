package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Services.PermissaoService;
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

    @GetMapping
    public String exibirListaPermissoes(Model model) {

        model.addAttribute("permissoes", permissaoService.buscarPermissoes());

        return "listapermissoes";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPermissao(@PathVariable Long id){

        permissaoService.excluirProduto(id);
        return ResponseEntity.ok("Permissão excluída com sucesso.");

    }

}
