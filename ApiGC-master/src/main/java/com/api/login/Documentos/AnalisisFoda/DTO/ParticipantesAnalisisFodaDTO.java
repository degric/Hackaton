package com.api.login.Documentos.AnalisisFoda.DTO;

import lombok.Data;

@Data
public class ParticipantesAnalisisFodaDTO {

    private Long idParticipantesAnalisisFoda;
    private String nombre;
    private String puesto;
    private Long idAnalisisFoda;  // Campo para relacionar con AnalisisFoda
}

