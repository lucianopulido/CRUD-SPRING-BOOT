package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.controllers;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.entity.Cliente;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class ClienteController {
    private IClienteService clienteService;

    @Autowired
    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", this.clienteService.findAll());
        return "listar";

    }

    @GetMapping("/clientes")
    public String crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("titulo", "Formulario de cliente");
        model.put("cliente", cliente);
        return "form";
    }

    @PostMapping("/clientes")
    public String guardar(Cliente cliente) {
        this.clienteService.save(cliente);
        return "redirect:listar";
    }

    @GetMapping("/clientes/{id}")
    public String editar(@PathVariable() Long id, Map<String, Object> model) {
        Cliente cliente = this.clienteService.findOne(id);
        model.put("cliente", cliente);
        model.put("titulo", "Editar cliente");
        return "form";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminar(@PathVariable() Long id) {
        this.clienteService.delete(id);
        return "redirect:/listar";
    }
}
