package com.api.login.Documentos.MatrizFodaEstrategica.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PlanAccionEstrategiasFodaDTO {

    private Long idPlanAccionEstrategiasFoda;
    private String tipo;
    private String estrategias;
    private String objetivo;
    private String folio;
    private String responsable;
    private LocalDate fechaMeta;
    private Long idMatrizFodaEstrategica;  // Campo para relacionar con MatrizFodaEstrategica
}
