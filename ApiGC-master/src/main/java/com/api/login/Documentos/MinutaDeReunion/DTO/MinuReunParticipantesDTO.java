package com.api.login.Documentos.MinutaDeReunion.DTO;

import lombok.Data;

@Data
public class MinuReunParticipantesDTO {

    private Long idMinuReunParticipantes;
    private String nombre;
    private Long idMinutaReunion;  // Relación con MinutaReunion
}

