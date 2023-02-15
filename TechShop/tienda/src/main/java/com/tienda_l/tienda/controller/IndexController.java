package com.tienda_l.tienda.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tienda_l.tienda.dao.ClienteDao;
import com.tienda_l.tienda.domain.Cliente;


@Controller
public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model){
        var texto="Texto escrito en semana 4";
        model.addAttribute("mensaje", texto);

        /*Cliente cliente = new Cliente("Ethan", "Fallas Solano", "correo@dementira.com", "1234-5678");
        Cliente cliente2 = new Cliente("Karen", "Solano Solis", "correo@dementira.com", "1234-5678");
        Cliente cliente3 = new Cliente("Juan Carlos", "Fallas Pastor", "correo@dementira.com", "1234-5678");
        Cliente cliente4 = new Cliente("Lineth", "Solano Solis", "correo@dementira.com", "1234-5678");

        var clientes = Arrays.asList(cliente, cliente2, cliente3, cliente4);*/
       
       
        var clientes = clienteDao.findAll();

        model.addAttribute("clientes", clientes);
        return "index";
    }
    
}
