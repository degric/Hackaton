package com.api.login.Documentos.SolicitudDePersonal.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SolicitudPersonalDTO {

    private Long idSolicitudPersonal;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    private DatosSolicitudPersonalDTO datosSolicitudPersonal;
}
