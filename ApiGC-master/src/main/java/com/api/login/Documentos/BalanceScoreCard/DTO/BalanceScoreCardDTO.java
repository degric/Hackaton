package com.api.login.Documentos.BalanceScoreCard.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BalanceScoreCardDTO {

    private Long idBalanceScoreCard;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Lista de perspectivas relacionadas
    private List<BalanceSCPrespectivaDTO> balanceSCPrespectivas;
}

