package com.api.login.Documentos.ListaDeAsistencia.DTO;

import lombok.Data;

@Data
public class TablaListaAsistenciaDTO {

    private Long idTablaListaAsistencia;
    private String nombreParticipante;
    private String puesto;
    private String firma;
    private Long idListaAsistencia;  // Relación con ListaAsistencia
}

