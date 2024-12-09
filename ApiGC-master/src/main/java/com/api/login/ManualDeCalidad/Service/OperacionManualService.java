package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.OperacionManual;

import java.util.List;

public interface OperacionManualService {

    List<OperacionManual> findAll();

    OperacionManual findById(Long id);

    OperacionManual save(OperacionManual operacionManual);

    OperacionManual update(Long id, OperacionManual operacionManual);

    void deleteById(Long id);

    List<OperacionManual> findByManualCalidadId(Long idManualCalidad);
}
