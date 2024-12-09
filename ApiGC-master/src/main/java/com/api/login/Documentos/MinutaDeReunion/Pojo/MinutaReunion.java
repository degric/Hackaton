package com.api.login.Documentos.MinutaDeReunion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "MinutaReunion")
public class MinutaReunion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMinutaReunion;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a muchos con MinuReunDatos
    @OneToMany(mappedBy = "minutaReunion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinuReunDatos> minuReunDatos = new ArrayList<>();

    // Relación uno a muchos con MinuReunParticipantes
    @OneToMany(mappedBy = "minutaReunion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinuReunParticipantes> minuReunParticipantes = new ArrayList<>();

    // Relación uno a muchos con MinuReunPuntosTratar
    @OneToMany(mappedBy = "minutaReunion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinuReunPuntosTratar> minuReunPuntosTratar = new ArrayList<>();

    // Relación uno a muchos con MinuReunResultadosAcuerdos
    @OneToMany(mappedBy = "minutaReunion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinuReunResultadosAcuerdos> minuReunResultadosAcuerdos = new ArrayList<>();
    // Relación uno a muchos con MinutaReunionSeguimiento
    @OneToMany(mappedBy = "minutaReunion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinutaReunionSeguimiento> minutaReunionSeguimientos = new ArrayList<>();


}
