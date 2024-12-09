package com.api.login.Documentos.MatrizFodaEstrategica.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MatrizFodaEstrategicaDTOSinListas {

    private Long idMatrizFodaEstrategica;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private LocalDate fechaRegistro;
}
