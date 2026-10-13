package com.api.alquilaya.services;

import com.api.alquilaya.models.OficinaModel;
import com.api.alquilaya.repositories.OficinaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OficinaService {
    private final OficinaRepository oficinaRepository;

    public OficinaService(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    public List<OficinaModel> obtenerTodas() {
        return oficinaRepository.findAll();
    }

    public OficinaModel guardar(OficinaModel oficina) {
        return oficinaRepository.save(oficina);
    }
}