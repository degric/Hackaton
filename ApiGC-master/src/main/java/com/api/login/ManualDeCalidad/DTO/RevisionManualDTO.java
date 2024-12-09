package com.api.login.ManualDeCalidad.DTO;
import lombok.Data;
import java.time.LocalDate;

@Data
public class RevisionManualDTO {

    private Long idRevisionManual;
    private String noRevision;
    private LocalDate fechaEmision;
    private String seccionAfectada;
    private String efectuadaPor;
    private LocalDate fechaEjecucion;
    private Long idManualCalidad;
}

