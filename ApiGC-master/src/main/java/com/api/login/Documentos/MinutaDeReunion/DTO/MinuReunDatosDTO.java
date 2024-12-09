package com.api.login.Documentos.MinutaDeReunion.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MinuReunDatosDTO {

    private Long idMinuReunDatos;
    private LocalDate fecha;
    private String departamento;
    private String asuntoATratar;
    private Long idMinutaReunion;  // Relación con MinutaReunion
}

