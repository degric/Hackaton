package com.api.login.Documentos.MinutaDeReunion.DTO;

import lombok.Data;

@Data
public class MinuReunPuntosTratarDTO {

    private Long idMinuReunPuntosTratar;
    private String punto;
    private Long idMinutaReunion;  // Relación con MinutaReunion
}

