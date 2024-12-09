package com.api.login.Documentos.AnalisisFoda.DTO;

import lombok.Data;

@Data
public class TablaAnalisisFodaDTO {

    private Long idTablaAnalisisFoda;
    private String departamento;
    private String fortalezas;
    private String oportunidades;
    private String debilidades;
    private String amanezas;
    private Long idAnalisisFoda;  // Campo para relacionar con AnalisisFoda
}
