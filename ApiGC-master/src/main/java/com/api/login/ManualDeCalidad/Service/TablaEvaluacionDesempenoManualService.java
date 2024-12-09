package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.TablaEvaluacionDesempenoManual;

import java.util.List;

public interface TablaEvaluacionDesempenoManualService {

    List<TablaEvaluacionDesempenoManual> findAll();

    TablaEvaluacionDesempenoManual findById(Long id);

    TablaEvaluacionDesempenoManual save(TablaEvaluacionDesempenoManual tablaEvaluacionDesempenoManual);

    TablaEvaluacionDesempenoManual update(Long id, TablaEvaluacionDesempenoManual tablaEvaluacionDesempenoManual);

    void deleteById(Long id);

    List<TablaEvaluacionDesempenoManual> findByManualCalidadId(Long idManualCalidad);
}
