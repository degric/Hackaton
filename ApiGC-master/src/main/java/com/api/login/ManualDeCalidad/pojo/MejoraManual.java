package com.api.login.ManualDeCalidad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MejoraManual")
public class MejoraManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMejora;

    private String titulo;

    @Column(length = 5000)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;
}
