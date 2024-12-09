package com.api.login.ManualDeCalidad.pojo;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IntroduccionManual")
public class IntroduccionManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntroduccionManual;

    private String titulo;

    @Column(length = 5000)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false )
    private ManualCalidad manualCalidad;
}

