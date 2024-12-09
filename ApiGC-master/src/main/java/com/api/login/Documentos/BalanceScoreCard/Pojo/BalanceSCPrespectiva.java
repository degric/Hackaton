package com.api.login.Documentos.BalanceScoreCard.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "BalanceSCPrespectiva")
public class BalanceSCPrespectiva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBalanceSCPrespectiva;

    private String contenido;

    // Relación muchos a uno con BalanceScoreCard
    @ManyToOne
    @JoinColumn(name = "idBalanceScoreCard")
    private BalanceScoreCard balanceScoreCard;

    // Relación uno a muchos con PartesInteresadas
    @OneToMany(mappedBy = "balanceSCPrespectiva", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartesInteresadas> partesInteresadas = new ArrayList<>();

    // Relación uno a muchos con MetricasBSC
    @OneToMany(mappedBy = "balanceSCPrespectiva", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MetricasBSC> metricasBSCList = new ArrayList<>();
}
