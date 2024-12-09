package com.api.login.Documentos.MinutaDeReunion.Service.Impl;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunParticipantesDTO;
import com.api.login.Documentos.MinutaDeReunion.Mapper.MinuReunParticipantesMapper;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunParticipantes;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinuReunParticipantesRepository;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinutaReunionRepository;
import com.api.login.Documentos.MinutaDeReunion.Service.MinuReunParticipantesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MinuReunParticipantesServiceImpl implements MinuReunParticipantesService {

    @Autowired
    private MinuReunParticipantesRepository minuReunParticipantesRepository;

    @Autowired
    private MinutaReunionRepository minutaReunionRepository;

    @Autowired
    private MinuReunParticipantesMapper minuReunParticipantesMapper;

    @Override
    public List<MinuReunParticipantesDTO> findAll() {
        return minuReunParticipantesRepository.findAll().stream()
                .map(minuReunParticipantesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinuReunParticipantesDTO findById(Long id) {
        MinuReunParticipantes participantes = minuReunParticipantesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante no encontrado"));
        return minuReunParticipantesMapper.toDTO(participantes);
    }

    @Override
    public List<MinuReunParticipantesDTO> findByMinutaReunion(Long idMinutaReunion) {
        List<MinuReunParticipantes> participantes = minuReunParticipantesRepository
                .findByMinutaReunion_IdMinutaReunion(idMinutaReunion);
        return participantes.stream()
                .map(minuReunParticipantesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinuReunParticipantesDTO save(MinuReunParticipantesDTO minuReunParticipantesDTO) {
        MinutaReunion minutaReunion = minutaReunionRepository
                .findById(minuReunParticipantesDTO.getIdMinutaReunion())
                .orElseThrow(() -> new EntityNotFoundException("Minuta de reunión no encontrada"));

        MinuReunParticipantes participantes = minuReunParticipantesMapper.toEntity(minuReunParticipantesDTO, minutaReunion);
        MinuReunParticipantes savedParticipantes = minuReunParticipantesRepository.save(participantes);
        return minuReunParticipantesMapper.toDTO(savedParticipantes);
    }

    @Override
    public MinuReunParticipantesDTO update(Long id, MinuReunParticipantesDTO minuReunParticipantesDTO) {
        MinuReunParticipantes existingParticipantes = minuReunParticipantesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante no encontrado"));

        existingParticipantes.setNombre(minuReunParticipantesDTO.getNombre());

        MinuReunParticipantes updatedParticipantes = minuReunParticipantesRepository.save(existingParticipantes);
        return minuReunParticipantesMapper.toDTO(updatedParticipantes);
    }

    @Override
    public void deleteById(Long id) {
        minuReunParticipantesRepository.deleteById(id);
    }
}

