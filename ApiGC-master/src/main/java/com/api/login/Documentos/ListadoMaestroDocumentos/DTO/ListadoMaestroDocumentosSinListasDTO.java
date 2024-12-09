package com.api.login.Documentos.ListadoMaestroDocumentos.DTO;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class ListadoMaestroDocumentosSinListasDTO {

    private Long idListadoMaestroDocumentos;

    private String coDocumento;

    private String noRevision;

    private LocalDate fechaEmicion;

    private LocalDate fechaRevision;

    // Lista de documentos relacionados
    private List<TablaLisMaDocumentosProcesosDTO> tablaLisMaDocumentosList;
}
