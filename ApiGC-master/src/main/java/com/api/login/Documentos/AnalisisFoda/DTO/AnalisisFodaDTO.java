package com.api.login.Documentos.AnalisisFoda.DTO;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class AnalisisFodaDTO {

    private Long idAnalisisFoda;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private LocalDate fechaRegistro;
    private List<TablaAnalisisFodaDTO> tablaAnalisisFoda;
    private List<ParticipantesAnalisisFodaDTO> participantesAnalisisFoda;  // Nueva lista para los participantes

}
