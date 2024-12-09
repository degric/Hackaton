package com.api.login.Documentos.MinutaDeReunion.DTO;

import lombok.Data;

@Data
public class MinutaReunionSeguimientoDTO {

    private Long idMinutaReunionSeguimiento;
    private String contenido;
    private Long idMinutaReunion;  // Relación con MinutaReunion
}

