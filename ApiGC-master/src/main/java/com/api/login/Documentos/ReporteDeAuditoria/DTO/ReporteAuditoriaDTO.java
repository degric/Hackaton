package com.api.login.Documentos.ReporteDeAuditoria.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReporteAuditoriaDTO {

    private Long idReporteAuditoria;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private InfoReporteAuditoriaDTO infoReporteAuditoria;
    private List<CierreReporteAuditoria1DTO> cierreReporteAuditoria1List;
    private List<CierreReporteAuditoria2DTO> cierreReporteAuditoria2List;
    private List<HallazgoReporteAuditoriaDTO> hallazgoReporteAuditoriaList;
}

