package com.api.login.Documentos.Planauditoria.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DatosPlanAuditoriaDTO {

    private Long idDatosPlanAuditoria;
    private String objetivoAuditoria;
    private String alcanceAuditoria;
    private String criteriosAuditorias;
    private LocalDate fechaElaboracion;
    private String noAuditoria;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private Long idPlanAuditoria;  // Relación con PlanAuditoria
}

