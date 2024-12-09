package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.DTO.MachoteDocumentosDTO;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;

import java.util.List;

import java.util.List;

public interface MachoteDocumentosService {
    MachoteDocumentosDTO getMachoteDocumentosById(Long id);
    List<MachoteDocumentosDTO> getAllMachoteDocumentos();

    List<MachoteDocumentosDTO> getByNivel(Long nivel);
}
