package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.LiderazgoManual;

import java.util.List;

public interface LiderazgoManualService {

    List<LiderazgoManual> findAll();

    LiderazgoManual findById(Long id);

    LiderazgoManual save(LiderazgoManual liderazgoManual);

    LiderazgoManual update(Long id, LiderazgoManual liderazgoManual);

    void deleteById(Long id);

    List<LiderazgoManual> findByManualCalidadId(Long idManualCalidad);
}

