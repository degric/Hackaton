package com.api.login.Documentos.BalanceScoreCard.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "BalanceScoreCard")
public class BalanceScoreCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBalanceScoreCard;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a muchos con BalanceSCPrespectiva
    @OneToMany(mappedBy = "balanceScoreCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BalanceSCPrespectiva> balanceSCPrespectivas = new ArrayList<>();
}

