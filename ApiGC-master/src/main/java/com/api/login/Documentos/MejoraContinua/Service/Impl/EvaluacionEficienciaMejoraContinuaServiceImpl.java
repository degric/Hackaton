package com.api.login.Documentos.MejoraContinua.Service.Impl;

import com.api.login.Documentos.MejoraContinua.DTO.EvaluacionEficienciaMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Mapper.EvaluacionEficienciaMejoraContinuaMapper;
import com.api.login.Documentos.MejoraContinua.Pojo.EvaluacionEficienciaMejoraContinua;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import com.api.login.Documentos.MejoraContinua.Repository.EvaluacionEficienciaMejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Repository.MejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Service.EvaluacionEficienciaMejoraContinuaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluacionEficienciaMejoraContinuaServiceImpl implements EvaluacionEficienciaMejoraContinuaService {

    @Autowired
    private EvaluacionEficienciaMejoraContinuaRepository evaluacionRepository;

    @Autowired
    private MejoraContinuaRepository mejoraRepository;

    @Autowired
    private EvaluacionEficienciaMejoraContinuaMapper evaluacionMapper;

    @Override
    public List<EvaluacionEficienciaMejoraContinuaDTO> findAll() {
        return evaluacionRepository.findAll().stream()
                .map(evaluacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EvaluacionEficienciaMejoraContinuaDTO findById(Long id) {
        EvaluacionEficienciaMejoraContinua evaluacion = evaluacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evaluación de Eficiencia no encontrada"));
        return evaluacionMapper.toDTO(evaluacion);
    }

    @Override
    public EvaluacionEficienciaMejoraContinuaDTO findByMejoraContinua(Long idMejoraContinua) {
        EvaluacionEficienciaMejoraContinua evaluacion = evaluacionRepository.findByMejoraContinua_IdMejoraContinua(idMejoraContinua)
                .orElseThrow(() -> new EntityNotFoundException("Evaluación de Eficiencia no encontrada para la Mejora Continua especificada"));
        return evaluacionMapper.toDTO(evaluacion);
    }

    @Override
    public EvaluacionEficienciaMejoraContinuaDTO save(EvaluacionEficienciaMejoraContinuaDTO evaluacionDTO) {
        MejoraContinua mejoraContinua = mejoraRepository.findById(evaluacionDTO.getIdMejoraContinua())
                .orElseThrow(() -> new EntityNotFoundException("Mejora Continua no encontrada"));

        EvaluacionEficienciaMejoraContinua evaluacion = evaluacionMapper.toEntity(evaluacionDTO, mejoraContinua);
        EvaluacionEficienciaMejoraContinua savedEvaluacion = evaluacionRepository.save(evaluacion);
        return evaluacionMapper.toDTO(savedEvaluacion);
    }

    @Override
    public EvaluacionEficienciaMejoraContinuaDTO update(Long id, EvaluacionEficienciaMejoraContinuaDTO evaluacionDTO) {
        EvaluacionEficienciaMejoraContinua existingEvaluacion = evaluacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evaluación de Eficiencia no encontrada"));

        existingEvaluacion.setPreguntaSeCumAccPro(evaluacionDTO.getPreguntaSeCumAccPro());
        existingEvaluacion.setObservacion1(evaluacionDTO.getObservacion1());
        existingEvaluacion.setPreguntaAunHayAccPen(evaluacionDTO.getPreguntaAunHayAccPen());
        existingEvaluacion.setObservacion2(evaluacionDTO.getObservacion2());
        existingEvaluacion.setPreguntaSeReAc(evaluacionDTO.getPreguntaSeReAc());

        EvaluacionEficienciaMejoraContinua updatedEvaluacion = evaluacionRepository.save(existingEvaluacion);
        return evaluacionMapper.toDTO(updatedEvaluacion);
    }

    @Override
    public void deleteById(Long id) {
        evaluacionRepository.deleteById(id);
    }
}

