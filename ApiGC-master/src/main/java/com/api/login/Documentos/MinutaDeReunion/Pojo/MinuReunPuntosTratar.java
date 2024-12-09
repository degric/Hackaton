package com.api.login.Documentos.MinutaDeReunion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MinuReunPuntosTratar")
public class MinuReunPuntosTratar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMinuReunPuntosTratar;

    private String punto;

    // Relación muchos a uno con MinutaReunion
    @ManyToOne
    @JoinColumn(name = "idMinutaReunion")
    private MinutaReunion minutaReunion;
}

