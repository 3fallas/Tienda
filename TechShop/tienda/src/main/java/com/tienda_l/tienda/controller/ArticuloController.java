package com.tienda_l.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda_l.tienda.domain.Articulo;

import services.ArticuloService;

@Service
@Controller
@RequestMapping("/Articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService ArticuloService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var Articulos = ArticuloService.getArticulos(false);

        model.addAttribute("Articulos", Articulos);
        model.addAttribute("totalArticulos", Articulos.size());
        return "/Articulo/listado";
    }

    @GetMapping("/nuevo")
    public String ArticuloNuevo(Articulo Articulo) {
        return "/Articulo/modifica";
    }

    @PostMapping("/guardar")
    public String ArticuloGuardar(Articulo Articulo) {
        ArticuloService.save(Articulo);
        return "redirect:/Articulo/listado";
    }

    @GetMapping("/eliminar/{idArticulo}")
    public String ArticuloEliminar(Articulo Articulo) {
        ArticuloService.delete(Articulo);
        return "redirect:/Articulo/listado";
    }

    @GetMapping("/modificar/{idArticulo}")
    public String ArticuloModificar(Articulo Articulo, Model model) {
        Articulo = ArticuloService.getArticulos(Articulo);
        model.addAttribute("Articulo", Articulo);
        return "/Articulo/modifica";
    }
}
