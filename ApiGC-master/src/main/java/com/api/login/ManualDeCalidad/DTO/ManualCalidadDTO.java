package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ManualCalidadDTO {

    private Long idManualCalidad;

    private LocalDate fechaEmision;

    private LocalDate fechaRevision;

    private String noRevision;

    private String coDocumento;

    private String coPie;
}
