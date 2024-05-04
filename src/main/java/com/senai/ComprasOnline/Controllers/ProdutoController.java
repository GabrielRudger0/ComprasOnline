package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.Services.CategoriaService;
import com.senai.ComprasOnline.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping()
    public String exibirCadastrarProduto(Model model) {
        ProdutoDTO cadastroDto = new ProdutoDTO();

        model.addAttribute("produtoDTO", cadastroDto);
        model.addAttribute("categorias", categoriaService.obterCategorias());
        return "cadastroproduto";
    }

    @PostMapping()
    public String cadastrarProduto(@ModelAttribute("produto") ProdutoDTO produtoDTO) {
        produtoService.inserirProduto(produtoDTO);
        return "redirect:/listaprodutos";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirProduto(@PathVariable Long id){

        System.out.println("entrou com o id: " + id);

        boolean sucesso = produtoService.excluirProduto(id);

        if (sucesso){
            return ResponseEntity.ok("Produto excluído com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir o produto.");

    }



}
