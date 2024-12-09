package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

@Data
public class DocumentosReManualCalidadDTO {
    private Long idDocumentosReManualCalidad;
    private String nombrePunto;
    private Long idSubpunto;
    private Long idManualCalidad;
    private Long idMachoteDocumentos;
}

