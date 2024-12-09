package com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class EvaluacionHabiPersonalDTO {

    private Long idEvaluacionHabiPersonal;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

}
