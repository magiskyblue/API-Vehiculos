package com.api.alquilaya.controllers;

import com.api.alquilaya.models.ClienteModel;
import com.api.alquilaya.services.ClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteModel> listar() {
        return clienteService.obtenerTodos();
    }

    @PostMapping
    public ClienteModel crear(@RequestBody ClienteModel cliente) {
        return clienteService.guardar(cliente);
    }
}