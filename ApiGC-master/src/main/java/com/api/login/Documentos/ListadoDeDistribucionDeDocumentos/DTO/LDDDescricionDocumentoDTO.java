package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LDDDescricionDocumentoDTO {

    private Long idLDDDescricionDocumento;
    private String descripcion;
    private String documento;
    private String area;
    private String codigoDocumento;
    private String revision;
    private LocalDate fechaImplantacion;
    private Long idListadoDistribucionDocumentos;  // Relación con ListadoDistribucionDocumentos
}

