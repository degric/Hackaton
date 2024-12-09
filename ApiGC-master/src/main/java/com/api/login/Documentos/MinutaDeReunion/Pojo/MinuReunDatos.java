package com.api.login.Documentos.MinutaDeReunion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "MinuReunDatos")
public class MinuReunDatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMinuReunDatos;

    private LocalDate fecha;
    private String departamento;
    private String asuntoATratar;

    // Relación muchos a uno con MinutaReunion
    @ManyToOne
    @JoinColumn(name = "idMinutaReunion")
    private MinutaReunion minutaReunion;
}

