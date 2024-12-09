package com.api.login.Documentos.PlanAuditorias.DTO;

import lombok.Data;

@Data
public class TablaPlanAuditoriasDTO {
    private Long idTablaPlanAuditorias;

    private String horario;

    private String horaFin;

    private String requisito;

    private String auditor;

    private String requisito1;

    private String auditor1;

    private String requisito2;

    private String auditor2;

    private Long idPlanAuditorias;
}

