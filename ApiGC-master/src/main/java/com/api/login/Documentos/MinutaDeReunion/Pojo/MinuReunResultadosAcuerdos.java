package com.api.login.Documentos.MinutaDeReunion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MinuReunResultadosAcuerdos")
public class MinuReunResultadosAcuerdos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMinuReunResultadosAcuerdos;

    private String contenido;

    // Relación muchos a uno con MinutaReunion
    @ManyToOne
    @JoinColumn(name = "idMinutaReunion")
    private MinutaReunion minutaReunion;
}

