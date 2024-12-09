package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.DTO.DocumentosReManualCalidadDTO;

import java.util.List;

public interface DocumentosReManualCalidadService {
    DocumentosReManualCalidadDTO createDocumentosReManualCalidad(DocumentosReManualCalidadDTO dto);
    DocumentosReManualCalidadDTO getDocumentosReManualCalidadById(Long id);
    List<DocumentosReManualCalidadDTO> getAllDocumentosReManualCalidad();
    DocumentosReManualCalidadDTO updateDocumentosReManualCalidad(Long id, DocumentosReManualCalidadDTO dto);
    void deleteDocumentosReManualCalidad(Long id);

    List<DocumentosReManualCalidadDTO> getIdManual(Long idManual);
}
