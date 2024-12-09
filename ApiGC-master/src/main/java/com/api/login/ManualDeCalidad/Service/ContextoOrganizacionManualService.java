package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.ContextoOrganizacionManual;

import java.util.List;

public interface ContextoOrganizacionManualService {

    List<ContextoOrganizacionManual> findAll();

    ContextoOrganizacionManual findById(Long id);

    ContextoOrganizacionManual save(ContextoOrganizacionManual contextoOrganizacionManual);

    ContextoOrganizacionManual update(Long id, ContextoOrganizacionManual contextoOrganizacionManual);

    void deleteById(Long id);

    List<ContextoOrganizacionManual> findByManualCalidadId(Long idManualCalidad);
}

