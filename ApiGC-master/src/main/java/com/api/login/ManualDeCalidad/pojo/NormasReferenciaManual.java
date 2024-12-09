package com.api.login.ManualDeCalidad.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NormasReferenciaManual")
public class NormasReferenciaManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNormasReferenciaManual;

    private String norma;

    @Column(length = 5000)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;
}

