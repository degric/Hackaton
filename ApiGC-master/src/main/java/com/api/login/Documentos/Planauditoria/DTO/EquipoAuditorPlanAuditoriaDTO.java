package com.api.login.Documentos.Planauditoria.DTO;

import lombok.Data;

@Data
public class EquipoAuditorPlanAuditoriaDTO {

    private Long idEquipoAuditorPlanAuditoria;
    private String auditorLider;
    private String auditores;
    private String auditoresEntrenamiento;
    private Long idPlanAuditoria;  // Relación con PlanAuditoria
}
