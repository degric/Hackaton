package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ListadoDistribucionDocumentosDTO {

    private Long idListadoDistribucionDocumentos;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Lista de descripciones de documentos relacionados
    private List<LDDDescricionDocumentoDTO> lddDescricionDocumentos;

    // Lista de tablas de distribución de documentos relacionadas
    private List<LDDocTablaDTO> lddDocTablas;
}

