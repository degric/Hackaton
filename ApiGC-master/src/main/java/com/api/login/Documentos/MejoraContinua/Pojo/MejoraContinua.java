package com.api.login.Documentos.MejoraContinua.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "MejoraContinua")
public class MejoraContinua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMejoraContinua;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a uno con DatosMejoraContinua
    @OneToOne(mappedBy = "mejoraContinua", cascade = CascadeType.ALL, orphanRemoval = true)
    private DatosMejoraContinua datosMejoraContinua;

    // Relación uno a muchos con TablaMejoraContinua
    @OneToMany(mappedBy = "mejoraContinua", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablaMejoraContinua> tablaMejoraContinuaList = new ArrayList<>();

    @OneToOne(mappedBy = "mejoraContinua", cascade = CascadeType.ALL, orphanRemoval = true)
    private EvaluacionEficienciaMejoraContinua evaluacionEficienciaMejoraContinua;

    @OneToMany(mappedBy = "mejoraContinua", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IntegrantesMejoraContinua> integrantesMejoraContinuaList = new ArrayList<>();


}
