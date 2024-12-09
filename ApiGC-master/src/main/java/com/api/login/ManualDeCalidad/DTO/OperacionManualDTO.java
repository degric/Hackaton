package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

@Data
public class OperacionManualDTO {

    private Long idOperacionManual;
    private String titulo;
    private String contenido;
    private Long idManualCalidad;
}
