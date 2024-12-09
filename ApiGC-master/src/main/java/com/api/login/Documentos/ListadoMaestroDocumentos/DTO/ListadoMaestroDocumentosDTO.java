package com.api.login.Documentos.ListadoMaestroDocumentos.DTO;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class ListadoMaestroDocumentosDTO {

    private Long idListadoMaestroDocumentos;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Agregamos la lista de procesos relacionados
    private List<TablaLisMaDocumentosProcesosDTO> procesos;

    private List<TablaLisMaDocumentosFormatosDTO> formatos;

    private List<TablaLisMaDocumentosAnexosDTO> anexos;
}

