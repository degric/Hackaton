package com.api.login.Documentos.AnalisisFoda.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "AnalisisFoda")
public class AnalisisFoda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnalisisFoda;

    private String coDocumento;

    private String noRevision;

    private LocalDate fechaEmicion;

    private LocalDate fechaRevision;

    private LocalDate fechaRegistro;

    // Relación uno a muchos con TablaAnalisisFoda
    @OneToMany(mappedBy = "analisisFoda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablaAnalisisFoda> tablaAnalisisFoda;

    // Relación uno a muchos con ParticipantesAnalisisFoda
    @OneToMany(mappedBy = "analisisFoda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParticipantesAnalisisFoda> participantesAnalisisFoda;
}

