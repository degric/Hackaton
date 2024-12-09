package com.api.login.Procesos.DTO;

import lombok.Data;

@Data
public class DocumentosReProcesosDTO {
    private Long idDocumentosReProcesos;
    private String nombrePunto;
    private Long nivelPunto;
    private Long idSubpunto;
    private Long idEnProceso;
    private Long idMachoteDocumentos;
}

