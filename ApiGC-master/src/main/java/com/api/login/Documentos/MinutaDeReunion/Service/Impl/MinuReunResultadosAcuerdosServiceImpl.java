package com.api.login.Documentos.MinutaDeReunion.Service.Impl;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunResultadosAcuerdosDTO;
import com.api.login.Documentos.MinutaDeReunion.Mapper.MinuReunResultadosAcuerdosMapper;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunResultadosAcuerdos;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinuReunResultadosAcuerdosRepository;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinutaReunionRepository;
import com.api.login.Documentos.MinutaDeReunion.Service.MinuReunResultadosAcuerdosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MinuReunResultadosAcuerdosServiceImpl implements MinuReunResultadosAcuerdosService {

    @Autowired
    private MinuReunResultadosAcuerdosRepository minuReunResultadosAcuerdosRepository;

    @Autowired
    private MinutaReunionRepository minutaReunionRepository;

    @Autowired
    private MinuReunResultadosAcuerdosMapper minuReunResultadosAcuerdosMapper;

    @Override
    public List<MinuReunResultadosAcuerdosDTO> findAll() {
        return minuReunResultadosAcuerdosRepository.findAll().stream()
                .map(minuReunResultadosAcuerdosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinuReunResultadosAcuerdosDTO findById(Long id) {
        MinuReunResultadosAcuerdos acuerdos = minuReunResultadosAcuerdosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Acuerdo no encontrado"));
        return minuReunResultadosAcuerdosMapper.toDTO(acuerdos);
    }

    @Override
    public List<MinuReunResultadosAcuerdosDTO> findByMinutaReunion(Long idMinutaReunion) {
        List<MinuReunResultadosAcuerdos> acuerdos = minuReunResultadosAcuerdosRepository
                .findByMinutaReunion_IdMinutaReunion(idMinutaReunion);
        return acuerdos.stream()
                .map(minuReunResultadosAcuerdosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinuReunResultadosAcuerdosDTO save(MinuReunResultadosAcuerdosDTO minuReunResultadosAcuerdosDTO) {
        MinutaReunion minutaReunion = minutaReunionRepository
                .findById(minuReunResultadosAcuerdosDTO.getIdMinutaReunion())
                .orElseThrow(() -> new EntityNotFoundException("Minuta de reunión no encontrada"));

        MinuReunResultadosAcuerdos acuerdos = minuReunResultadosAcuerdosMapper.toEntity(minuReunResultadosAcuerdosDTO, minutaReunion);
        MinuReunResultadosAcuerdos savedAcuerdos = minuReunResultadosAcuerdosRepository.save(acuerdos);
        return minuReunResultadosAcuerdosMapper.toDTO(savedAcuerdos);
    }

    @Override
    public MinuReunResultadosAcuerdosDTO update(Long id, MinuReunResultadosAcuerdosDTO minuReunResultadosAcuerdosDTO) {
        MinuReunResultadosAcuerdos existingAcuerdos = minuReunResultadosAcuerdosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Acuerdo no encontrado"));

        existingAcuerdos.setContenido(minuReunResultadosAcuerdosDTO.getContenido());

        MinuReunResultadosAcuerdos updatedAcuerdos = minuReunResultadosAcuerdosRepository.save(existingAcuerdos);
        return minuReunResultadosAcuerdosMapper.toDTO(updatedAcuerdos);
    }

    @Override
    public void deleteById(Long id) {
        minuReunResultadosAcuerdosRepository.deleteById(id);
    }
}

