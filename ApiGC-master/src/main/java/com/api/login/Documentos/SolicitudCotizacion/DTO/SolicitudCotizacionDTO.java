package com.api.login.Documentos.SolicitudCotizacion.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class SolicitudCotizacionDTO {
    private Integer idSolicitudCotizacion;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

    private String nomSolicita;
}
