package com.api.login.Documentos.BalanceScoreCard.DTO;

import lombok.Data;

import java.util.List;

@Data
public class BalanceSCPrespectivaDTO {

    private Long idBalanceSCPrespectiva;
    private String contenido;
    private Long idBalanceScoreCard;  // Relación con BalanceScoreCard

    // Lista de partes interesadas relacionadas
    private List<PartesInteresadasDTO> partesInteresadas;

    // Lista de métricas relacionadas
    private List<MetricasBSCDTO> metricasBSCList;
}

