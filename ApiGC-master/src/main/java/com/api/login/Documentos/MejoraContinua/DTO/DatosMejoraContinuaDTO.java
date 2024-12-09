package com.api.login.Documentos.MejoraContinua.DTO;

import lombok.Data;

@Data
public class DatosMejoraContinuaDTO {

    private Long idDatosMejoraContinua;
    private String alcance;
    private String numeroControl;
    private String objetivo;
    private String origenMejora;
    private String descripcionAccion;
    private String descriocion;
    private String cuantificacion;
    private String periodo;
    private String tiempoInicial;
    private String tiempoFinal;
    private String resultado;
    private Long idMejoraContinua;  // Relación con MejoraContinua
}
