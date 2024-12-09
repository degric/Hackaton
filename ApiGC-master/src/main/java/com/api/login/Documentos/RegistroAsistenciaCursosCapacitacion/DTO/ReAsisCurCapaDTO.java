package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class ReAsisCurCapaDTO {

    private Long idReAsisCurCapa;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;
}
