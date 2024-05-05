package com.senai.ComprasOnline.Controllers;

import com.senai.ComprasOnline.Enum.AcaoSistema;
import com.senai.ComprasOnline.Services.CategoriaService;
import com.senai.ComprasOnline.Services.ControleSessaoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listacategorias")
public class ListaCategoriasController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    ControleSessaoService controleSessao;

    @GetMapping
    public String exibirListaCategorias(Model model, HttpServletRequest request) {

        if (!controleSessao.validarUsuarioSessao(request).isEmpty()) {
            return "redirect:/login";
        }

        boolean permAtualizarCategoria = controleSessao.validarUsuarioPermissao(request, AcaoSistema.ATUALIZAR_CATEGORIA);
        boolean permExcluirCategoria = controleSessao.validarUsuarioPermissao(request, AcaoSistema.EXCLUIR_CATEGORIA);

        model.addAttribute("permAtualizarCategoria", permAtualizarCategoria);
        model.addAttribute("permExcluirCategoria", permExcluirCategoria);

        model.addAttribute("categorias", categoriaService.obterCategorias());
        return "listacategorias";
    }


}
