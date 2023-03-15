package com.tienda_l.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import services.ArticuloService;

@Service
@Controller
public class IndexController {
    @Autowired
    private ArticuloService articuloService;
    @GetMapping("/")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        return "index";
    }
}
