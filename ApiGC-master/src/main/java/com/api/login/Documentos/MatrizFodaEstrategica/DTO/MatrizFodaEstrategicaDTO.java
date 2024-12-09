package com.api.login.Documentos.MatrizFodaEstrategica.DTO;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class MatrizFodaEstrategicaDTO {

    private Long idMatrizFodaEstrategica;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private LocalDate fechaRegistro;
    private List<FortalezasMatrizFodaEstrategicaDTO> fortalezas;  // Nueva lista para las fortalezas
    private List<DebilidadesMatrizFodaEstrategicaDTO> debilidades;  // Nueva lista para las debilidades
    private List<OportunidadesMatrizFodaEstrategicaDTO> oportunidades;  // Nueva lista para las oportunidades
    private List<EstrategiasFOMatrizFodaEstrategicaDTO> estrategiasFO;  // Nueva lista para las estrategias FO
    private List<EstrategiasDOMatrizFodaEstrategicaDTO> estrategiasDO;  // Nueva lista para las estrategias DO
    private List<AmenazasMatrizFodaEstrategicaDTO> amenazas;
    private List<EstrategiasFAMatrizFodaEstrategicaDTO> estrategiasFA; // Nueva lista para las estrategias FA
    private List<EstrategiasDAMatrizFodaEstrategicaDTO> estrategiasDA; // Nueva lista para las estrategias DA
    private List<PlanAccionEstrategiasFodaDTO> planesAccion; // Nueva lista para los planes de acción


}
