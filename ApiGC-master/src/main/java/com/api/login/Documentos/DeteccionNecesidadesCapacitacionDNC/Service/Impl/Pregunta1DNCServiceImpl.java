package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Impl;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.Pregunta1DNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.DetecionNeCaDNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.Pregunta1DNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.Pregunta1DNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.Pregunta1DNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Pregunta1DNCService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Pregunta1DNCServiceImpl implements Pregunta1DNCService {

    @Autowired
    private Pregunta1DNCRepository preguntaRepository;

    @Autowired
    private DetecionNeCaDNCRepository detecionRepository;

    @Autowired
    private Pregunta1DNCMapper preguntaMapper;

    @Override
    public List<Pregunta1DNCDTO> findAll() {
        return preguntaRepository.findAll().stream()
                .map(preguntaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Pregunta1DNCDTO findById(Long id) {
        Pregunta1DNC pregunta = preguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada"));
        return preguntaMapper.toDTO(pregunta);
    }

    @Override
    public List<Pregunta1DNCDTO> findByDetecionNeCaDNC(Long idDetecionNeCaDNC) {
        return preguntaRepository.findByDetecionNeCaDNC_IdDetecionNeCaDNC(idDetecionNeCaDNC).stream()
                .map(preguntaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Pregunta1DNCDTO save(Pregunta1DNCDTO pregunta1DNCDTO) {
        DetecionNeCaDNC detecionNeCaDNC = detecionRepository.findById(pregunta1DNCDTO.getIdDetecionNeCaDNC())
                .orElseThrow(() -> new EntityNotFoundException("Detección de Necesidades no encontrada"));

        Pregunta1DNC pregunta = preguntaMapper.toEntity(pregunta1DNCDTO, detecionNeCaDNC);
        Pregunta1DNC savedPregunta = preguntaRepository.save(pregunta);
        return preguntaMapper.toDTO(savedPregunta);
    }

    @Override
    public Pregunta1DNCDTO update(Long id, Pregunta1DNCDTO pregunta1DNCDTO) {
        Pregunta1DNC existingPregunta = preguntaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada"));

        existingPregunta.setContenido1(pregunta1DNCDTO.getContenido1());
        existingPregunta.setContenido2(pregunta1DNCDTO.getContenido2());
        existingPregunta.setContenido3(pregunta1DNCDTO.getContenido3());

        Pregunta1DNC updatedPregunta = preguntaRepository.save(existingPregunta);
        return preguntaMapper.toDTO(updatedPregunta);
    }

    @Override
    public void deleteById(Long id) {
        preguntaRepository.deleteById(id);
    }
}
