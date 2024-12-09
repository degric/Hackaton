package com.api.login.Documentos.MejoraContinua.DTO;

import lombok.Data;

@Data
public class IntegrantesMejoraContinuaDTO {

    private Long idIntegrantesMejoraContinua;
    private String integrante;
    private String puesto;
    private String firma;
    private Long idMejoraContinua;  // Relación con MejoraContinua
}

