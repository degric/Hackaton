package com.api.login.Documentos.Planauditoria.DTO;

import lombok.Data;

@Data
public class CuerpoPlanAuditoriaDTO {

    private Long idCuerpoPlanAuditoria;
    private String inicio;
    private String termino;
    private String procesoAuditar;
    private String requisitosNorma;
    private String contraparteAuditada;
    private String auditor;
    private Long idPlanAuditoria;  // Relación con PlanAuditoria
}

