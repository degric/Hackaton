package com.api.login.Documentos.AnalisisFoda.Pojo;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "TablaAnalisisFoda")
public class TablaAnalisisFoda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaAnalisisFoda;

    private String departamento;
    private String fortalezas;
    private String oportunidades;
    private String debilidades;
    private String amanezas;

    @ManyToOne
    @JoinColumn(name = "idAnalisisFoda", nullable = false)
    private AnalisisFoda analisisFoda;
}

