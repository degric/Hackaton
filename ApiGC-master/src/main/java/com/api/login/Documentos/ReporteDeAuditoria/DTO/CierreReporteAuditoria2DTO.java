package com.api.login.Documentos.ReporteDeAuditoria.DTO;

import lombok.Data;

@Data
public class CierreReporteAuditoria2DTO {

    private Long idCierreReporteAuditoria2;
    private String nombreAuditor;
    private String firma;
    private Long idReporteAuditoria;  // Relación con ReporteAuditoria
}
