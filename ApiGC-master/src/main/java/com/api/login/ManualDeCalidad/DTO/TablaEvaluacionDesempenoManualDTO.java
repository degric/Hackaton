package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

@Data
public class TablaEvaluacionDesempenoManualDTO {

    private Long idTablaEvaluacionDesempenoManual;
    private String queEvaluar;
    private String metodoSeguimientoMedicion;
    private String cuandoDarSeguimientoMedicion;
    private String cuandoAnalizarEvaluarResultados;
    private Long idManualCalidad;
}

