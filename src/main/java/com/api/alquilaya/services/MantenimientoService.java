package com.api.alquilaya.services;

import com.api.alquilaya.models.MantenimientoModel;
import com.api.alquilaya.repositories.MantenimientoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MantenimientoService {
    private final MantenimientoRepository mantenimientoRepository;

    public MantenimientoService(MantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    public List<MantenimientoModel> obtenerTodos() {
        return mantenimientoRepository.findAll();
    }

    public MantenimientoModel guardar(MantenimientoModel mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }
}