package com.api.alquilaya.controllers;

import com.api.alquilaya.models.MantenimientoModel;
import com.api.alquilaya.services.MantenimientoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mantenimientos")
public class MantenimientoController {
    private final MantenimientoService mantenimientoService;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    @GetMapping
    public List<MantenimientoModel> listar() {
        return mantenimientoService.obtenerTodos();
    }

    @PostMapping
    public MantenimientoModel crear(@RequestBody MantenimientoModel mantenimiento) {
        return mantenimientoService.guardar(mantenimiento);
    }
}