package com.api.login.Documentos.ProgramaAuditoriasInternas.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class ProgramaAuditoriasInternasDTO {

    private Integer idProgramaAuditoriasInternas;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

    private String anio;
}
