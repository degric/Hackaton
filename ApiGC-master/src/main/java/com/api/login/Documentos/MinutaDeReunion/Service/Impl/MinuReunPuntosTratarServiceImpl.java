package com.api.login.Documentos.MinutaDeReunion.Service.Impl;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunPuntosTratarDTO;
import com.api.login.Documentos.MinutaDeReunion.Mapper.MinuReunPuntosTratarMapper;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunPuntosTratar;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinuReunPuntosTratarRepository;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinutaReunionRepository;
import com.api.login.Documentos.MinutaDeReunion.Service.MinuReunPuntosTratarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MinuReunPuntosTratarServiceImpl implements MinuReunPuntosTratarService {

    @Autowired
    private MinuReunPuntosTratarRepository minuReunPuntosTratarRepository;

    @Autowired
    private MinutaReunionRepository minutaReunionRepository;

    @Autowired
    private MinuReunPuntosTratarMapper minuReunPuntosTratarMapper;

    @Override
    public List<MinuReunPuntosTratarDTO> findAll() {
        return minuReunPuntosTratarRepository.findAll().stream()
                .map(minuReunPuntosTratarMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinuReunPuntosTratarDTO findById(Long id) {
        MinuReunPuntosTratar puntos = minuReunPuntosTratarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Punto no encontrado"));
        return minuReunPuntosTratarMapper.toDTO(puntos);
    }

    @Override
    public List<MinuReunPuntosTratarDTO> findByMinutaReunion(Long idMinutaReunion) {
        List<MinuReunPuntosTratar> puntos = minuReunPuntosTratarRepository
                .findByMinutaReunion_IdMinutaReunion(idMinutaReunion);
        return puntos.stream()
                .map(minuReunPuntosTratarMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinuReunPuntosTratarDTO save(MinuReunPuntosTratarDTO minuReunPuntosTratarDTO) {
        MinutaReunion minutaReunion = minutaReunionRepository
                .findById(minuReunPuntosTratarDTO.getIdMinutaReunion())
                .orElseThrow(() -> new EntityNotFoundException("Minuta de reunión no encontrada"));

        MinuReunPuntosTratar puntos = minuReunPuntosTratarMapper.toEntity(minuReunPuntosTratarDTO, minutaReunion);
        MinuReunPuntosTratar savedPuntos = minuReunPuntosTratarRepository.save(puntos);
        return minuReunPuntosTratarMapper.toDTO(savedPuntos);
    }

    @Override
    public MinuReunPuntosTratarDTO update(Long id, MinuReunPuntosTratarDTO minuReunPuntosTratarDTO) {
        MinuReunPuntosTratar existingPuntos = minuReunPuntosTratarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Punto no encontrado"));

        existingPuntos.setPunto(minuReunPuntosTratarDTO.getPunto());

        MinuReunPuntosTratar updatedPuntos = minuReunPuntosTratarRepository.save(existingPuntos);
        return minuReunPuntosTratarMapper.toDTO(updatedPuntos);
    }

    @Override
    public void deleteById(Long id) {
        minuReunPuntosTratarRepository.deleteById(id);
    }
}

