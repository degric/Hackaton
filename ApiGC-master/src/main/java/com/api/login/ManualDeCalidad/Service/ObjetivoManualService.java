package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.ObjetivoManual;

import java.util.List;

public interface ObjetivoManualService {

    List<ObjetivoManual> findAll();

    ObjetivoManual findById(Long id);

    ObjetivoManual save(ObjetivoManual objetivoManual);

    ObjetivoManual update(Long id, ObjetivoManual objetivoManual);

    void deleteById(Long id);

    List<ObjetivoManual> findByManualCalidadId(Long idManualCalidad);
}

