package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

@Data
public class IntroduccionManualDTO {

    private Long idIntroduccionManual;

    private String titulo;

    private String contenido;

    private Long idManualCalidad;
}
