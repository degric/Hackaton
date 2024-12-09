package com.api.login.Documentos.MinutaDeReunion.Service.Impl;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinutaReunionSeguimientoDTO;
import com.api.login.Documentos.MinutaDeReunion.Mapper.MinutaReunionSeguimientoMapper;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunionSeguimiento;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinutaReunionRepository;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinutaReunionSeguimientoRepository;
import com.api.login.Documentos.MinutaDeReunion.Service.MinutaReunionSeguimientoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MinutaReunionSeguimientoServiceImpl implements MinutaReunionSeguimientoService {

    @Autowired
    private MinutaReunionSeguimientoRepository minutaReunionSeguimientoRepository;

    @Autowired
    private MinutaReunionRepository minutaReunionRepository;

    @Autowired
    private MinutaReunionSeguimientoMapper minutaReunionSeguimientoMapper;

    @Override
    public List<MinutaReunionSeguimientoDTO> findAll() {
        return minutaReunionSeguimientoRepository.findAll().stream()
                .map(minutaReunionSeguimientoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinutaReunionSeguimientoDTO findById(Long id) {
        MinutaReunionSeguimiento seguimiento = minutaReunionSeguimientoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));
        return minutaReunionSeguimientoMapper.toDTO(seguimiento);
    }

    @Override
    public List<MinutaReunionSeguimientoDTO> findByMinutaReunion(Long idMinutaReunion) {
        List<MinutaReunionSeguimiento> seguimientos = minutaReunionSeguimientoRepository
                .findByMinutaReunion_IdMinutaReunion(idMinutaReunion);
        return seguimientos.stream()
                .map(minutaReunionSeguimientoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinutaReunionSeguimientoDTO save(MinutaReunionSeguimientoDTO minutaReunionSeguimientoDTO) {
        MinutaReunion minutaReunion = minutaReunionRepository
                .findById(minutaReunionSeguimientoDTO.getIdMinutaReunion())
                .orElseThrow(() -> new EntityNotFoundException("Minuta de reunión no encontrada"));

        MinutaReunionSeguimiento seguimiento = minutaReunionSeguimientoMapper.toEntity(minutaReunionSeguimientoDTO, minutaReunion);
        MinutaReunionSeguimiento savedSeguimiento = minutaReunionSeguimientoRepository.save(seguimiento);
        return minutaReunionSeguimientoMapper.toDTO(savedSeguimiento);
    }

    @Override
    public MinutaReunionSeguimientoDTO update(Long id, MinutaReunionSeguimientoDTO minutaReunionSeguimientoDTO) {
        MinutaReunionSeguimiento existingSeguimiento = minutaReunionSeguimientoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));

        existingSeguimiento.setContenido(minutaReunionSeguimientoDTO.getContenido());

        MinutaReunionSeguimiento updatedSeguimiento = minutaReunionSeguimientoRepository.save(existingSeguimiento);
        return minutaReunionSeguimientoMapper.toDTO(updatedSeguimiento);
    }

    @Override
    public void deleteById(Long id) {
        minutaReunionSeguimientoRepository.deleteById(id);
    }
}

