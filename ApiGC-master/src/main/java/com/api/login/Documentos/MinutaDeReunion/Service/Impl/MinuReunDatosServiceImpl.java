package com.api.login.Documentos.MinutaDeReunion.Service.Impl;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunDatosDTO;
import com.api.login.Documentos.MinutaDeReunion.Mapper.MinuReunDatosMapper;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunDatos;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinuReunDatosRepository;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinutaReunionRepository;
import com.api.login.Documentos.MinutaDeReunion.Service.MinuReunDatosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MinuReunDatosServiceImpl implements MinuReunDatosService {

    @Autowired
    private MinuReunDatosRepository minuReunDatosRepository;

    @Autowired
    private MinutaReunionRepository minutaReunionRepository;

    @Autowired
    private MinuReunDatosMapper minuReunDatosMapper;

    @Override
    public List<MinuReunDatosDTO> findAll() {
        return minuReunDatosRepository.findAll().stream()
                .map(minuReunDatosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinuReunDatosDTO findById(Long id) {
        MinuReunDatos datos = minuReunDatosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos no encontrados"));
        return minuReunDatosMapper.toDTO(datos);
    }

    @Override
    public List<MinuReunDatosDTO> findByMinutaReunion(Long idMinutaReunion) {
        List<MinuReunDatos> datos = minuReunDatosRepository
                .findByMinutaReunion_IdMinutaReunion(idMinutaReunion);
        return datos.stream()
                .map(minuReunDatosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinuReunDatosDTO save(MinuReunDatosDTO minuReunDatosDTO) {
        MinutaReunion minutaReunion = minutaReunionRepository
                .findById(minuReunDatosDTO.getIdMinutaReunion())
                .orElseThrow(() -> new EntityNotFoundException("Minuta de reunión no encontrada"));

        MinuReunDatos datos = minuReunDatosMapper.toEntity(minuReunDatosDTO, minutaReunion);
        MinuReunDatos savedDatos = minuReunDatosRepository.save(datos);
        return minuReunDatosMapper.toDTO(savedDatos);
    }

    @Override
    public MinuReunDatosDTO update(Long id, MinuReunDatosDTO minuReunDatosDTO) {
        MinuReunDatos existingDatos = minuReunDatosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos no encontrados"));

        existingDatos.setFecha(minuReunDatosDTO.getFecha());
        existingDatos.setDepartamento(minuReunDatosDTO.getDepartamento());
        existingDatos.setAsuntoATratar(minuReunDatosDTO.getAsuntoATratar());

        MinuReunDatos updatedDatos = minuReunDatosRepository.save(existingDatos);
        return minuReunDatosMapper.toDTO(updatedDatos);
    }

    @Override
    public void deleteById(Long id) {
        minuReunDatosRepository.deleteById(id);
    }
}

