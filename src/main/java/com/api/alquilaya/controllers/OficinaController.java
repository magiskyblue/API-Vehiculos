package com.api.alquilaya.controllers;

import com.api.alquilaya.models.OficinaModel;
import com.api.alquilaya.services.OficinaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/oficinas")
public class OficinaController {
    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping
    public List<OficinaModel> listar() {
        return oficinaService.obtenerTodas();
    }

    @PostMapping
    public OficinaModel crear(@RequestBody OficinaModel oficina) {
        return oficinaService.guardar(oficina);
    }
}