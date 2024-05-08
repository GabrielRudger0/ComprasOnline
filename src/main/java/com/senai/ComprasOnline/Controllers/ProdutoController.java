package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.Services.CategoriaService;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.ProdutoService;
import com.senai.ComprasOnline.Services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping()
    public String exibirCadastrarProduto(Model model, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/";
        }

        ProdutoDTO cadastroDto = new ProdutoDTO();

        model.addAttribute("produtoDTO", cadastroDto);
        model.addAttribute("categorias", categoriaService.obterCategorias());
        return "cadastroproduto";
    }

    @PostMapping()
    public String cadastrarProduto(@ModelAttribute("produto") ProdutoDTO produtoDTO, HttpServletRequest request) {

        HttpSession sessao = request.getSession();
        String email = "";
        if (sessao.getAttribute("usuarioemail") != null) {
            email = sessao.getAttribute("usuarioemail").toString();
        }

        produtoDTO.setUsuarioEmail(email);

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
