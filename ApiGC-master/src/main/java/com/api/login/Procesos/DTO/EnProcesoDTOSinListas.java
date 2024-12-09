package com.api.login.Procesos.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnProcesoDTOSinListas {
    private Long idEnProceso;

    private LocalDate fechaElaboracion;

    private LocalDate fechaEdicion;

    private String noRevision;

    private String coDocumento;

    private String nombreProceso;

    private String coPie;
}
