package com.api.alquilaya.controllers;

import com.api.alquilaya.models.VehiculoModel;
import com.api.alquilaya.services.VehiculoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<VehiculoModel> listar() {
        return vehiculoService.obtenerTodos();
    }

    @PostMapping
    public VehiculoModel crear(@RequestBody VehiculoModel vehiculo) {
        return vehiculoService.guardar(vehiculo);
    }
}