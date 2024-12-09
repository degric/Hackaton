package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

@Data
@Entity
@Table(name = "EnProceso")
public class EnProceso {
    @Id
    @Column(name = "idEnProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnProceso;

    private LocalDate fechaElaboracion;

    private LocalDate fechaEdicion;

    private String noRevision;

    private String coDocumento;

    private String nombreProceso;

    private String coPie;

    @OneToOne(mappedBy = "enProceso",cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private ObjetivoProceso objetivoProceso;

    @OneToOne(mappedBy = "enProceso",cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private AlcanceProceso alcanceProceso;

    @OneToMany(mappedBy = "enProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<DoReferenciaProceso> doReferenciaProceso;

    @OneToMany(mappedBy = "enProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<ResponsaProceso> responsaProcesos;

    @OneToMany(mappedBy = "enProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<AbreProdeso> abreProdesos;

    //cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true
    @OneToMany(mappedBy = "enProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<DesarrolloProceso> desarrolloProceso;

    @OneToMany(mappedBy = "enProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<DiTortugaProceso> diTortugaProcesos;


    @OneToOne(mappedBy = "enProceso",cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY)
    private DistribucionProceso distribucionProceso;


    @OneToMany(mappedBy = "enProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<HisRevisionesProceso> hisRevisionesProcesos;

    @OneToMany(mappedBy = "enProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<DocumentosReProcesos> documentosReProcesos;
}


