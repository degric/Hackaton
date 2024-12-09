package com.api.login.ManualDeCalidad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OperacionManual")
public class OperacionManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperacionManual;

    private String titulo;

    @Column(length = 8000)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;
}

