package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.IntroduccionManual;

import java.util.List;

public interface IntroduccionManualService {

    List<IntroduccionManual> findAll();

    IntroduccionManual findById(Long id);

    IntroduccionManual save(IntroduccionManual introduccionManual);

    IntroduccionManual update(Long id, IntroduccionManual introduccionManual);

    void deleteById(Long id);

    List<IntroduccionManual> findByManualCalidadId(Long idManualCalidad);
}
