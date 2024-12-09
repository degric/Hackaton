package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO;

import lombok.Data;

@Data
public class LDDocTablaDTO {

    private Long idLDDocTabla;
    private String nombreReceptor;
    private String puesto;
    private String firma;
    private Long idListadoDistribucionDocumentos;  // Relación con ListadoDistribucionDocumentos
}
