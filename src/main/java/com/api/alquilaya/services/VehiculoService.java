package com.api.alquilaya.services;

import com.api.alquilaya.models.VehiculoModel;
import com.api.alquilaya.repositories.VehiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<VehiculoModel> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    public VehiculoModel guardar(VehiculoModel vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}