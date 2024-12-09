package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.ApoyoManual;

import java.util.List;

public interface ApoyoManualService {

    List<ApoyoManual> findAll();

    ApoyoManual findById(Long id);

    ApoyoManual save(ApoyoManual apoyoManual);

    ApoyoManual update(Long id, ApoyoManual apoyoManual);

    void deleteById(Long id);

    List<ApoyoManual> findByManualCalidadId(Long idManualCalidad);
}

