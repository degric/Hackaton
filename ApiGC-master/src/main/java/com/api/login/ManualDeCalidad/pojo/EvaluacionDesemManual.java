package com.api.login.ManualDeCalidad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EvaluacionDesemManual")
public class EvaluacionDesemManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluacionDesemManual;

    private String titulo;

    @Column(length = 3000)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;
}
