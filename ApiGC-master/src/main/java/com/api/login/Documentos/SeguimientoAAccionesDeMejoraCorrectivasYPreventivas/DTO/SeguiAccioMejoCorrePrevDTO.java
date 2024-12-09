package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SeguiAccioMejoCorrePrevDTO {

    private Long idSeguiAccioMejoCorrePrev;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;


    // Lista de tablas de seguimiento de acciones correctivas relacionadas
    private List<SeAcMeCoPrTablaDTO> seAcMeCoPrTablas;
}

