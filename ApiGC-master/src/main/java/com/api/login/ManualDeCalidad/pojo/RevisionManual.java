package com.api.login.ManualDeCalidad.pojo;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "RevisionManual")
public class RevisionManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevisionManual;

    private String noRevision;

    private LocalDate fechaEmision;

    private String seccionAfectada;

    private String efectuadaPor;

    private LocalDate fechaEjecucion;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;
}

