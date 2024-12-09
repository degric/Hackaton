package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.MejoraManual;

import java.util.List;

public interface MejoraManualService {

    List<MejoraManual> findAll();

    MejoraManual findById(Long id);

    MejoraManual save(MejoraManual mejoraManual);

    MejoraManual update(Long id, MejoraManual mejoraManual);

    void deleteById(Long id);

    List<MejoraManual> findByManualCalidadId(Long idManualCalidad);
}

