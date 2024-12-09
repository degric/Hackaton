package com.api.login.Documentos.ListadoMaestroDocumentos.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TablaLisMaDocumentosProcesosDTO {

    private Long idTablaLisMaDocumentosProcesos;
    private String codigo;
    private String nombredocumento;
    private String departamento;
    private String responsable;
    private String noRevision;
    private LocalDate elaborado;
    private LocalDate revisado;
    private LocalDate modificado;
    private Long idListadoMaestroDocumentos;  // Relación con ListadoMaestroDocumentos
}


