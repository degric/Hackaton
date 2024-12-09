package com.api.login.Documentos.MejoraContinua.Service;

import com.api.login.Documentos.MejoraContinua.DTO.EvaluacionEficienciaMejoraContinuaDTO;

import java.util.List;

public interface EvaluacionEficienciaMejoraContinuaService {

    List<EvaluacionEficienciaMejoraContinuaDTO> findAll();

    EvaluacionEficienciaMejoraContinuaDTO findById(Long id);

    EvaluacionEficienciaMejoraContinuaDTO findByMejoraContinua(Long idMejoraContinua);

    EvaluacionEficienciaMejoraContinuaDTO save(EvaluacionEficienciaMejoraContinuaDTO evaluacionDTO);

    EvaluacionEficienciaMejoraContinuaDTO update(Long id, EvaluacionEficienciaMejoraContinuaDTO evaluacionDTO);

    void deleteById(Long id);
}
