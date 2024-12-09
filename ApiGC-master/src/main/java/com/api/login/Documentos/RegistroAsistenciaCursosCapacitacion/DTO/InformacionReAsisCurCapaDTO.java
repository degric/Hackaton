package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class InformacionReAsisCurCapaDTO {
    private Long idInformacionReAsisCurCapa;

    private Date fecha;

    private String nomCurso;

    private String instructor;

    private String duracion;

    private String responsable;

    private Long idReAsisCurCapa;
}
