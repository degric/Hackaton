package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.EvaluacionDesemManual;

import java.util.List;

public interface EvaluacionDesemManualService {

    List<EvaluacionDesemManual> findAll();

    EvaluacionDesemManual findById(Long id);

    EvaluacionDesemManual save(EvaluacionDesemManual evaluacionDesemManual);

    EvaluacionDesemManual update(Long id, EvaluacionDesemManual evaluacionDesemManual);

    void deleteById(Long id);

    List<EvaluacionDesemManual> findByManualCalidadId(Long idManualCalidad);
}

