package com.api.login.Documentos.ProgramaAuditoriasInternas.DTO;

import lombok.Data;

@Data
public class TablaProAuInternasDTO {
    private Integer idTablaProAuInternas;

    private String areaAuditada;

    private String mes1AuIn;

    private String mes2AuIn;

    private String mesAuEx;

    private Integer idProgramaAuditoriasInternas;
}
