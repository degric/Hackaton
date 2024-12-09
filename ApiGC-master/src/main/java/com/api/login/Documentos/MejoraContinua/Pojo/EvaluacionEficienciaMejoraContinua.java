package com.api.login.Documentos.MejoraContinua.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EvaluacionEficienciaMejoraContinua")
public class EvaluacionEficienciaMejoraContinua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluacionEficienciaMejoraContinua;

    private String preguntaSeCumAccPro;
    private String observacion1;

    private String preguntaAunHayAccPen;
    private String observacion2;

    private String preguntaSeReAc;

    // Relación uno a uno con MejoraContinua
    @OneToOne
    @JoinColumn(name = "idMejoraContinua", referencedColumnName = "idMejoraContinua")
    private MejoraContinua mejoraContinua;
}

