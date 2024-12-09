package com.api.login.Documentos.BalanceScoreCard.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MetricasBSC")
public class MetricasBSC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetricasBSC;

    private String objetivo;
    private Integer meta;
    private String frecuencia;
    private String responsable;
    private Integer estadoActual;

    // Relación muchos a uno con BalanceSCPrespectiva
    @ManyToOne
    @JoinColumn(name = "idBalanceSCPrespectiva")
    private BalanceSCPrespectiva balanceSCPrespectiva;
}

