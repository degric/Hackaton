package com.api.login.ManualDeCalidad.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "ManualCalidad")
public class ManualCalidad {

    @Id
    @Column(name = "idManualCalidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManualCalidad;

    private LocalDate fechaEmision;

    private LocalDate fechaRevision;

    private String noRevision;

    private String coDocumento;

    private String coPie;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<IntroduccionManual> introducciones;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<ObjetivoManual> objetivoManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<NormasReferenciaManual> normasReferenciaManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<LiderazgoManual> liderazgoManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<ContextoOrganizacionManual> contextoOrganizacionManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<OperacionManual> operacionManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<PlanificacionManual> planificacionManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<ApoyoManual> apoyoManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<EvaluacionDesemManual> evaluacionDesemManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<TablaEvaluacionDesempenoManual> tablaEvaluacionDesempenoManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<MejoraManual> mejoraManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<RevisionManual> revisionManual;

    @OneToMany(mappedBy = "manualCalidad", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<DocumentosReManualCalidad> documentosReManualCalidad;

}
