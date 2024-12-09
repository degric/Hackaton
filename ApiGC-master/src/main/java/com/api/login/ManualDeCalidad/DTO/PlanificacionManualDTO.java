package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

@Data
public class PlanificacionManualDTO {

    private Long idPlanificacionManual;
    private String titulo;
    private String contenido;
    private Long idManualCalidad;
}

