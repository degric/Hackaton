package com.api.login.ManualDeCalidad.DTO;

import lombok.Data;

@Data
public class NormasReferenciaManualDTO {

    private Long idNormasReferenciaManual;
    private String norma;
    private String descripcion;
    private Long idManualCalidad;
}

