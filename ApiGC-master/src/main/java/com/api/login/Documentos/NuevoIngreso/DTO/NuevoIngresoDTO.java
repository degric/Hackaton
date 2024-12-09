package com.api.login.Documentos.NuevoIngreso.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class NuevoIngresoDTO {
    private Integer idNuevoIngreso;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;
}
