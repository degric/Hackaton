package com.api.login.Documentos.ControlDocumentosExternos.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TablaControlDocumentosExternosDTO {

    private Long idTablaControlDocumentosExternos;
    private String numero;
    private String externo;
    private String codigo;
    private String nombreDocumento;
    private String revision;
    private LocalDate fechaEmocion;
    private LocalDate fechaRevision;
    private LocalDate fechaUltimoCambio;
    private Long idControlDocumentosExternos;
}

