package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.pojo.RevisionManual;

import java.util.List;

public interface RevisionManualService {

    List<RevisionManual> findAll();

    RevisionManual findById(Long id);

    RevisionManual save(RevisionManual revisionManual);

    RevisionManual update(Long id, RevisionManual revisionManual);

    void deleteById(Long id);

    List<RevisionManual> findByManualCalidadId(Long idManualCalidad);
}
