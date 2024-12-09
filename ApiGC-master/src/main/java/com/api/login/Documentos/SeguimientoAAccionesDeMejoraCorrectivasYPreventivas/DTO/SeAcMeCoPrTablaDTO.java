package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeAcMeCoPrTablaDTO {

    private Long idSeAcMeCoPrTabla;
    private String hallazgo;
    private String evidenciasObservadas;
    private String responsableAreaImplantacion;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private String avance;
    private String revisionValoracion;
    private Long idSeguiAccioMejoCorrePrev;  // Relación con SeguiAccioMejoCorrePrev
}

