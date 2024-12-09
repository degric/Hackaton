package com.api.login.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class LisDisDocumentosDTO {
    private Integer idLisDisDocumentos;

    private Date fechaEmosion;

    private Date fechaRevision;

    private String coDocumentos;

    private String noRevision;

    private String status;

    private String descripcion;
}
