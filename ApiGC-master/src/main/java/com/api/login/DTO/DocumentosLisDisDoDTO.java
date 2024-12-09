package com.api.login.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class DocumentosLisDisDoDTO {

    private Integer idDocumentosLisDisDo;

    private String area;

    private String coDocumento;

    private String revision;

    private Date fechaImplantacion;

    private Integer idLisDisDocumentos;
}
