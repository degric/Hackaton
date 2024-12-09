package com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class DatosEvaluacionHaPersonalDTO {
    private Long idDatosEvaluacionHaPersonal;

    private String nombre;

    private String puesto;

    private Date fechaEvaluacion;

    private String evaluador;

    private Integer promedio;

    private Long idEvaluacionHabiPersonal;
}
