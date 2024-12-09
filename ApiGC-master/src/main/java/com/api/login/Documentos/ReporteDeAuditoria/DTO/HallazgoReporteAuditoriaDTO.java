package com.api.login.Documentos.ReporteDeAuditoria.DTO;

import lombok.Data;

@Data
public class HallazgoReporteAuditoriaDTO {

    private Long idHallazgoReporteAuditoria;
    private String clausulaNorma;
    private String tipoHallazgo;
    private String comentario;
    private Long idReporteAuditoria;  // Relación con ReporteAuditoria
}

