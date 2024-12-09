package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Impl;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.Preguntas2DNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.DetecionNeCaDNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.Preguntas2DNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.Preguntas2DNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.Preguntas2DNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Preguntas2DNCService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Preguntas2DNCServiceImpl implements Preguntas2DNCService {

    @Autowired
    private Preguntas2DNCRepository preguntasRepository;

    @Autowired
    private DetecionNeCaDNCRepository detecionRepository;

    @Autowired
    private Preguntas2DNCMapper preguntasMapper;

    @Override
    public List<Preguntas2DNCDTO> findAll() {
        return preguntasRepository.findAll().stream()
                .map(preguntasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Preguntas2DNCDTO findById(Long id) {
        Preguntas2DNC pregunta = preguntasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada"));
        return preguntasMapper.toDTO(pregunta);
    }

    @Override
    public List<Preguntas2DNCDTO> findByDetecionNeCaDNC(Long idDetecionNeCaDNC) {
        return preguntasRepository.findByDetecionNeCaDNC_IdDetecionNeCaDNC(idDetecionNeCaDNC).stream()
                .map(preguntasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Preguntas2DNCDTO save(Preguntas2DNCDTO preguntas2DNCDTO) {
        DetecionNeCaDNC detecionNeCaDNC = detecionRepository.findById(preguntas2DNCDTO.getIdDetecionNeCaDNC())
                .orElseThrow(() -> new EntityNotFoundException("Detección de Necesidades no encontrada"));

        Preguntas2DNC pregunta = preguntasMapper.toEntity(preguntas2DNCDTO, detecionNeCaDNC);
        Preguntas2DNC savedPregunta = preguntasRepository.save(pregunta);
        return preguntasMapper.toDTO(savedPregunta);
    }

    @Override
    public Preguntas2DNCDTO update(Long id, Preguntas2DNCDTO preguntas2DNCDTO) {
        Preguntas2DNC existingPregunta = preguntasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pregunta no encontrada"));

        existingPregunta.setContenido1(preguntas2DNCDTO.getContenido1());
        existingPregunta.setContenido2(preguntas2DNCDTO.getContenido2());
        existingPregunta.setContenido3(preguntas2DNCDTO.getContenido3());

        Preguntas2DNC updatedPregunta = preguntasRepository.save(existingPregunta);
        return preguntasMapper.toDTO(updatedPregunta);
    }

    @Override
    public void deleteById(Long id) {
        preguntasRepository.deleteById(id);
    }
}
