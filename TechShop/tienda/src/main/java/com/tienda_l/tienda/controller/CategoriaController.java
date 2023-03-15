package com.tienda_l.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda_l.tienda.domain.Categoria;

import services.CategoriaService;

@Service
@Controller
@RequestMapping("/Categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService CategoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var Categorias = CategoriaService.getCategorias(false);

        model.addAttribute("Categorias", Categorias);
        model.addAttribute("totalCategorias", Categorias.size());
        return "/Categoria/listado";
    }

    @GetMapping("/nuevo")
    public String CategoriaNuevo(Categoria Categoria) {
        return "/Categoria/modifica";
    }

    @PostMapping("/guardar")
    public String CategoriaGuardar(Categoria Categoria) {
        CategoriaService.save(Categoria);
        return "redirect:/Categoria/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String CategoriaEliminar(Categoria Categoria) {
        CategoriaService.delete(Categoria);
        return "redirect:/Categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String CategoriaModificar(Categoria Categoria, Model model) {
        Categoria = CategoriaService.getCategoria(Categoria);
        model.addAttribute("Categoria", Categoria);
        return "/Categoria/modifica";
    }
}
