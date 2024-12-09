package com.api.login.Documentos.MinutaDeReunion.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MinutaReunionDTO {

    private Long idMinutaReunion;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Lista de datos de la reunión relacionados
    private List<MinuReunDatosDTO> minuReunDatos;

    // Lista de participantes de la reunión relacionados
    private List<MinuReunParticipantesDTO> minuReunParticipantes;
    // Lista de puntos a tratar de la reunión relacionados
    private List<MinuReunPuntosTratarDTO> minuReunPuntosTratar;

    // Lista de resultados de acuerdos de la reunión relacionados
    private List<MinuReunResultadosAcuerdosDTO> minuReunResultadosAcuerdos;
    // Lista de seguimientos de la reunión relacionados
    private List<MinutaReunionSeguimientoDTO> minutaReunionSeguimientos;


}

