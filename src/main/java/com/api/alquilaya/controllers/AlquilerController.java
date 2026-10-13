package com.api.alquilaya.controllers;

import com.api.alquilaya.models.AlquilerModel;
import com.api.alquilaya.services.AlquilerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {
    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping
    public List<AlquilerModel> listar() {
        return alquilerService.obtenerTodos();
    }

    @PostMapping
    public AlquilerModel crear(@RequestBody AlquilerModel alquiler) {
        return alquilerService.crearAlquiler(alquiler);
    }
}