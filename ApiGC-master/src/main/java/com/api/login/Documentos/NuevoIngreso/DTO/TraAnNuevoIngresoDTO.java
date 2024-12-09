package com.api.login.Documentos.NuevoIngreso.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class TraAnNuevoIngresoDTO {
    private Integer idTraAnNuevoIngreso;

    private String fecha;

    private String lugar;

    private String funDesempenadas;

    private Integer idNuevoIngreso;
}
