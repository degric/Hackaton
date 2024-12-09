package com.api.login.Documentos.MejoraContinua.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MejoraContinuaDTO {

    private Long idMejoraContinua;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    private DatosMejoraContinuaDTO datosMejoraContinua;
    private List<TablaMejoraContinuaDTO> tablaMejoraContinuaList;
    private EvaluacionEficienciaMejoraContinuaDTO evaluacionEficienciaMejoraContinua;
    private List<IntegrantesMejoraContinuaDTO> integrantesMejoraContinuaList;
}

