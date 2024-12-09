package com.api.login.Documentos.BalanceScoreCard.DTO;

import lombok.Data;

@Data
public class MetricasBSCDTO {

    private Long idMetricasBSC;
    private String objetivo;
    private Integer meta;
    private String frecuencia;
    private String responsable;
    private Integer estadoActual;
    private Long idBalanceSCPrespectiva;  // Relación con BalanceSCPrespectiva
}

