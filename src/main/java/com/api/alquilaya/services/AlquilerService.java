package com.api.alquilaya.services;

import com.api.alquilaya.models.*;
import com.api.alquilaya.repositories.AlquilerRepository;
import com.api.alquilaya.repositories.ClienteRepository;
import com.api.alquilaya.repositories.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AlquilerService {
    private final AlquilerRepository alquilerRepository;
    private final VehiculoRepository vehiculoRepository;
    private final ClienteRepository clienteRepository;

    public AlquilerService(AlquilerRepository alquilerRepository,
                           VehiculoRepository vehiculoRepository,
                           ClienteRepository clienteRepository) {
        this.alquilerRepository = alquilerRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<AlquilerModel> obtenerTodos() {
        return alquilerRepository.findAll();
    }

    public AlquilerModel crearAlquiler(AlquilerModel alquiler) {
        VehiculoModel vehiculo = vehiculoRepository.findById(alquiler.getVehiculo().getId())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        ClienteModel cliente = clienteRepository.findById(alquiler.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (vehiculo.getEstado() != EstadoVehiculo.Disponible) {
            throw new RuntimeException("El vehículo no está disponible");
        }

        long dias = ChronoUnit.DAYS.between(alquiler.getFechaInicio(), alquiler.getFechaFin());
        if (dias <= 0) dias = 1;

        alquiler.setPrecioTotal(dias * vehiculo.getTarifaDiaria());
        alquiler.setVehiculo(vehiculo);
        alquiler.setCliente(cliente);
        alquiler.setEstado(EstadoAlquiler.Activo);

        vehiculo.setEstado(EstadoVehiculo.Alquilado);
        vehiculoRepository.save(vehiculo);

        return alquilerRepository.save(alquiler);
    }
}