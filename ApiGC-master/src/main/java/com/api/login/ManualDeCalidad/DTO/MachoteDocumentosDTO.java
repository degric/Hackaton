package com.api.login.ManualDeCalidad.DTO;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class MachoteDocumentosDTO {
    private Long idMachoteDocumentos;
    private String nombreDocumento;
    private Long idDocumento;
    private Integer nivelDocumento;
    private String codigoDocumento;
}

