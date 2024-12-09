package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.PlanificacionManual;

import java.util.List;

public interface PlanificacionManualService {

    List<PlanificacionManual> findAll();

    PlanificacionManual findById(Long id);

    PlanificacionManual save(PlanificacionManual planificacionManual);

    PlanificacionManual update(Long id, PlanificacionManual planificacionManual);

    void deleteById(Long id);

    List<PlanificacionManual> findByManualCalidadId(Long idManualCalidad);
}

