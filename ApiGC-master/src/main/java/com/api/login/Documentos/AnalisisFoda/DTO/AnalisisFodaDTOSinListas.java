package com.api.login.Documentos.AnalisisFoda.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AnalisisFodaDTOSinListas {
    private Long idAnalisisFoda;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private LocalDate fechaRegistro;
}
