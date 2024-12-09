package com.api.login.ManualDeCalidad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TablaEvaluacionDesempenoManual")
public class TablaEvaluacionDesempenoManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaEvaluacionDesempenoManual;

    private String queEvaluar;

    private String metodoSeguimientoMedicion;

    private String cuandoDarSeguimientoMedicion;

    private String cuandoAnalizarEvaluarResultados;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;
}

