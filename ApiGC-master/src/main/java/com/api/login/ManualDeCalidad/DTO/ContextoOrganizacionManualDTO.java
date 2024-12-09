package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

@Data
public class ContextoOrganizacionManualDTO {

    private Long idContextoOrganizacionManual;
    private String titulo;
    private String contenido;
    private Long idManualCalidad;
}

