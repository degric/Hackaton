package com.api.login.Documentos.MejoraContinua.DTO;

import lombok.Data;

@Data
public class EvaluacionEficienciaMejoraContinuaDTO {

    private Long idEvaluacionEficienciaMejoraContinua;
    private String preguntaSeCumAccPro;
    private String observacion1;
    private String preguntaAunHayAccPen;
    private String observacion2;
    private String preguntaSeReAc;
    private Long idMejoraContinua;  // Relación con MejoraContinua
}

