package com.api.login.ManualDeCalidad.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ObjetivoManual")
public class ObjetivoManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjetivoManual;

    @Column(length = 5000)
    private String objetivo;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;
}

