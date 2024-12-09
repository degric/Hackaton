package com.api.login.Documentos.ReporteDeAuditoria.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InfoReporteAuditoriaDTO {

    private Long idInfoReporteAuditoria;
    private String procesoAuditado;
    private String responSGC;
    private LocalDate fecha;
    private String noAuditoria;
    private String calificacion;
    private Long idReporteAuditoria;  // Relación con ReporteAuditoria
}
