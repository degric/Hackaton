package com.api.login.Documentos.PlanAuditorias.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class ContenidoPlanAuditoriasDTO {
    private Long idContenidoPlanAuditorias;

    private String noAuditoria;

    private Date fecha;

    private String areas;

    private String objetivos;

    private String alcance;

    private String auditores;

    private String criterios;

    private Long idPlanAuditorias;
}
