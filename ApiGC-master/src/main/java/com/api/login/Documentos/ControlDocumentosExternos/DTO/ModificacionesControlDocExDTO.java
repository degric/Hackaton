package com.api.login.Documentos.ControlDocumentosExternos.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ModificacionesControlDocExDTO {

    private Long idModificacionesControlDocEx;
    private LocalDate fechaCambio;
    private String edRev;
    private String cambiosRealizadosVerAn;
    private Long idControlDocumentosExternos;  // Campo para relacionar con ControlDocumentosExternos
}

