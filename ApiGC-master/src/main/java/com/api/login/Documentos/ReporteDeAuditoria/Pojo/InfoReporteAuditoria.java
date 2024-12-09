package com.api.login.Documentos.ReporteDeAuditoria.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "InfoReporteAuditoria")
public class InfoReporteAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInfoReporteAuditoria;

    private String procesoAuditado;
    private String responSGC;
    private LocalDate fecha;
    private String noAuditoria;
    private String calificacion;

    // Relación uno a uno con ReporteAuditoria
    @OneToOne
    @JoinColumn(name = "idReporteAuditoria", referencedColumnName = "idReporteAuditoria")
    private ReporteAuditoria reporteAuditoria;
}
