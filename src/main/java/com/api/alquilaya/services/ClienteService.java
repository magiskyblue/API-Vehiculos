package com.api.alquilaya.services;

import com.api.alquilaya.models.ClienteModel;
import com.api.alquilaya.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public ClienteModel guardar(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }
}