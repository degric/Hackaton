package com.api.login.ManualDeCalidad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ApoyoManual")
public class ApoyoManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApoyoManual;

    private String titulo;

    @Column(length = 7000)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;
}

