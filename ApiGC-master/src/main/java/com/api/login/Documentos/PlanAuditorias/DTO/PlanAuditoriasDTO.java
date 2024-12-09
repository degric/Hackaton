package com.api.login.Documentos.PlanAuditorias.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class PlanAuditoriasDTO {

    private Long idPlanAuditorias;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;
}
