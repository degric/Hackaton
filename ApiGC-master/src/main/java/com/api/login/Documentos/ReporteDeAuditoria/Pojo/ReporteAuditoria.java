package com.api.login.Documentos.ReporteDeAuditoria.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ReporteAuditoria")
public class ReporteAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReporteAuditoria;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a uno con InfoReporteAuditoria
    @OneToOne(mappedBy = "reporteAuditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private InfoReporteAuditoria infoReporteAuditoria;

    // Relación uno a muchos con CierreReporteAuditoria1
    @OneToMany(mappedBy = "reporteAuditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CierreReporteAuditoria1> cierreReporteAuditoria1List = new ArrayList<>();


    @OneToMany(mappedBy = "reporteAuditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CierreReporteAuditoria2> cierreReporteAuditoria2List = new ArrayList<>();

    @OneToMany(mappedBy = "reporteAuditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HallazgoReporteAuditoria> hallazgoReporteAuditoriaList = new ArrayList<>();


}

