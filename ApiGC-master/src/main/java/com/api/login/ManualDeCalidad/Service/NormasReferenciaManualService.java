package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.NormasReferenciaManual;

import java.util.List;

public interface NormasReferenciaManualService {

    List<NormasReferenciaManual> findAll();

    NormasReferenciaManual findById(Long id);

    NormasReferenciaManual save(NormasReferenciaManual normasReferenciaManual);

    NormasReferenciaManual update(Long id, NormasReferenciaManual normasReferenciaManual);

    void deleteById(Long id);

    List<NormasReferenciaManual> findByManualCalidadId(Long idManualCalidad);
}

