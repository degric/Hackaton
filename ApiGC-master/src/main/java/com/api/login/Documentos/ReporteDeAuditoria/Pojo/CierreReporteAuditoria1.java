package com.api.login.Documentos.ReporteDeAuditoria.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CierreReporteAuditoria1")
public class CierreReporteAuditoria1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCierreReporteAuditoria1;

    private String nombreAuditor;
    private String firma;

    // Relación muchos a uno con ReporteAuditoria
    @ManyToOne
    @JoinColumn(name = "idReporteAuditoria")
    private ReporteAuditoria reporteAuditoria;
}

