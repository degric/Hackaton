package com.api.login.Documentos.Planauditoria.DTO;

import lombok.Data;

@Data
public class ObservacionesPlanAuditoriasDTO {

    private Long idObservacionesPlanAuditorias;
    private String observacion;
    private Long idPlanAuditoria;  // Relación con PlanAuditoria
}

