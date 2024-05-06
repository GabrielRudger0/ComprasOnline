package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.DTOs.BuscarProdutoDTO;
import com.senai.ComprasOnline.DTOs.ProdutoDTO;
import com.senai.ComprasOnline.Enum.AcaoSistema;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import com.senai.ComprasOnline.Services.ProdutoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/listaprodutos")
public class ListaProdutosController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping()
    public String exibirListaProdutos(Model model, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/";
        }

        boolean permCadastroProduto = controleSessao.validarUsuarioPermissao(request, AcaoSistema.CADASTRO_PRODUTO);
        boolean permVisualizarProduto = controleSessao.validarUsuarioPermissao(request, AcaoSistema.VISUALIZAR_PRODUTO);
        boolean permAtualizarProduto = controleSessao.validarUsuarioPermissao(request, AcaoSistema.ATUALIZAR_PRODUTO);
        boolean permExcluirProduto = controleSessao.validarUsuarioPermissao(request, AcaoSistema.EXCLUIR_PRODUTO);

        model.addAttribute("buscarProdutoDTO", new BuscarProdutoDTO(""));
        model.addAttribute("produtos", produtoService.obterListaProdutos());

        model.addAttribute("permCadastroProduto", permCadastroProduto);
        model.addAttribute("permVisualizarProduto", permVisualizarProduto);
        model.addAttribute("permAtualizarProduto", permAtualizarProduto);
        model.addAttribute("permExcluirProduto", permExcluirProduto);

        return "listaprodutos";
    }

    @PostMapping()
    public String buscarProduto(Model model, @ModelAttribute("buscarProdutoDTO") BuscarProdutoDTO buscarProdutoDTO){

        model.addAttribute("produtos", produtoService.buscarProduto(buscarProdutoDTO.getItemBusca()));

        return "listaprodutos";
    }


}
