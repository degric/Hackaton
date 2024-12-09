package com.api.login.Documentos.BalanceScoreCard.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PartesInteresadasDTO {

    private Long idPartesInteresadas;
    private String nombre;
    private String interes;
    private String influencia;
    private Long idBalanceSCPrespectiva;  // Relación con BalanceSCPrespectiva


}

