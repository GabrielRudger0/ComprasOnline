package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCategoria(@PathVariable Long id){

        boolean sucesso = categoriaService.excluirCategoria(id);

        if (sucesso){
            return ResponseEntity.ok("Categoria excluída com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir categoria.");

    }

}
