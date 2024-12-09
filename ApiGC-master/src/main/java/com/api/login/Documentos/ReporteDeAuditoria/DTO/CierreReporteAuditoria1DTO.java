package com.api.login.Documentos.ReporteDeAuditoria.DTO;

import lombok.Data;

@Data
public class CierreReporteAuditoria1DTO {

    private Long idCierreReporteAuditoria1;
    private String nombreAuditor;
    private String firma;
    private Long idReporteAuditoria;  // Relación con ReporteAuditoria
}
