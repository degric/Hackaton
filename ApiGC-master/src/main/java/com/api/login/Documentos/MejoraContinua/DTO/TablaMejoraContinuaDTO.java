package com.api.login.Documentos.MejoraContinua.DTO;

import lombok.Data;

@Data
public class TablaMejoraContinuaDTO {

    private Long idTablaMejoraContinua;
    private String queSeVaHacer;
    private String metaEsperada;
    private Long idMejoraContinua;  // Relación con MejoraContinua
}

