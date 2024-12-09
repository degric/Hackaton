package com.api.login.Documentos.AnalisisFoda.Service.Impl;

import com.api.login.Documentos.AnalisisFoda.DTO.AnalisisFodaDTOSinListas;
import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Repository.AnalisisFodaRepository;
import com.api.login.Documentos.AnalisisFoda.Service.AnalisisFodaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnalisisFodaServiceImpl implements AnalisisFodaService {

    @Autowired
    private AnalisisFodaRepository analisisFodaRepository;

    @Override
    public List<AnalisisFoda> findAll() {
        return analisisFodaRepository.findAll();
    }

    @Override
    public AnalisisFoda findById(Long id) {
        Optional<AnalisisFoda> optional = analisisFodaRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public AnalisisFoda save(AnalisisFoda analisisFoda) {
        return analisisFodaRepository.save(analisisFoda);
    }

    @Override
    public AnalisisFoda update(Long id, AnalisisFodaDTOSinListas analisisFodaDTO) {
        // Buscar el registro existente de AnalisisFoda
        AnalisisFoda existingAnalisisFoda = analisisFodaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AnalisisFoda not found"));

        // Actualizar solo los campos de AnalisisFoda sin tocar las tablas relacionadas
        existingAnalisisFoda.setCoDocumento(analisisFodaDTO.getCoDocumento());
        existingAnalisisFoda.setNoRevision(analisisFodaDTO.getNoRevision());
        existingAnalisisFoda.setFechaEmicion(analisisFodaDTO.getFechaEmicion());
        existingAnalisisFoda.setFechaRevision(analisisFodaDTO.getFechaRevision());
        existingAnalisisFoda.setFechaRegistro(analisisFodaDTO.getFechaRegistro());

        // Guardar el registro actualizado
        return analisisFodaRepository.save(existingAnalisisFoda);
    }

    @Override
    public void deleteById(Long id) {
        analisisFodaRepository.deleteById(id);
    }
}

