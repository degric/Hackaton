package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO;

import lombok.Data;

@Data
public class TablaReAsisCurCapaDTO {
    private Long idTablaReAsisCurCapa;

    private String nombre;

    private String puesto;

    private String area;

    private String firma;

    private Long idReAsisCurCapa;
}
