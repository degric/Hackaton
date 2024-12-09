package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

@Data
public class EvaluacionDesemManualDTO {

    private Long idEvaluacionDesemManual;
    private String titulo;
    private String contenido;
    private Long idManualCalidad;
}
