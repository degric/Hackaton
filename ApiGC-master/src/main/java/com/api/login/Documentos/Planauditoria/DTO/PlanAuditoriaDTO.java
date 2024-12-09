package com.api.login.Documentos.Planauditoria.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PlanAuditoriaDTO {

    private Long idPlanAuditoria;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Lista de datos del plan de auditoría
    private List<DatosPlanAuditoriaDTO> datosPlanAuditoriaList;

    private List<EquipoAuditorPlanAuditoriaDTO> equipoAuditorList;

    private List<CuerpoPlanAuditoriaDTO> cuerpoPlanAuditoriaList;

    private List<ObservacionesPlanAuditoriasDTO> observacionesList;
}
