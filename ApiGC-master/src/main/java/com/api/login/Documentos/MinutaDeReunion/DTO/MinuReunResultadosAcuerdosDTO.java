package com.api.login.Documentos.MinutaDeReunion.DTO;

import lombok.Data;

@Data
public class MinuReunResultadosAcuerdosDTO {

    private Long idMinuReunResultadosAcuerdos;
    private String contenido;
    private Long idMinutaReunion;  // Relación con MinutaReunion
}

