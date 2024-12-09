package com.api.login.Documentos.ControlDocumentosExternos.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ControlDocumentosExternosDTOSinListas {
    private Long idControlDocumentosExternos;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private String area;
    private String seccion;
    private LocalDate fecha;
}
