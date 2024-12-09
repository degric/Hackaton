package com.api.login.Procesos.DTO;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class HisRevisionesProcesoDTO {

    private Long idHisRevisionProceso;

    private String numeroRevision;

    private LocalDate fecha;

    private String seccionAfectada;

    private String efectuadoPor;

    private LocalDate fechaEjecucion;

    private Long idEnProceso;
}

