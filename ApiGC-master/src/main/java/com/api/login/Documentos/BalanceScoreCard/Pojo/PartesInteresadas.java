package com.api.login.Documentos.BalanceScoreCard.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PartesInteresadas")
public class PartesInteresadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartesInteresadas;

    private String nombre;
    private String interes;
    private String influencia;

    // Relación muchos a uno con BalanceSCPrespectiva
    @ManyToOne
    @JoinColumn(name = "idBalanceSCPrespectiva")
    private BalanceSCPrespectiva balanceSCPrespectiva;
}

