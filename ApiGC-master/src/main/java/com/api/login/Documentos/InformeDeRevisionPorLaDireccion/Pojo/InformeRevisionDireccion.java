package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "InformeRevisionDireccion")
public class InformeRevisionDireccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInformeRevisionDireccion;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a muchos con InformeRevisionDireccionEntrada
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InformeRevisionDireccionEntrada> entradas = new ArrayList<>();

    // Relación uno a muchos con EntradasRevisiondireccion_A
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntradasRevisiondireccion_A> entradasRevisiondireccion_A = new ArrayList<>();

    // Relación uno a muchos con EntradasRevisiondireccion_B
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntradasRevisiondireccion_B> entradasRevisiondireccion_B = new ArrayList<>();

    // Relación uno a muchos con EntradasRevisiondireccion_C
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntradasRevisiondireccion_C> entradasRevisiondireccion_C = new ArrayList<>();

    // Relación uno a muchos con IRDObjetivosCalidad
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IRDObjetivosCalidad> irdObjetivosCalidad = new ArrayList<>();

    // Relación uno a muchos con IRDProcesosConformidadServicios
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IRDProcesosConformidadServicios> irdProcesosConformidadServicios = new ArrayList<>();
    // Relación uno a muchos con IRDNoConformidadesAcCorrectivas
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IRDNoConformidadesAcCorrectivas> irdNoConformidadesAcCorrectivas = new ArrayList<>();
    // Relación uno a muchos con IRDResultadosSeguimientoMedicion
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IRDResultadosSeguimientoMedicion> irdResultadosSeguimientoMedicion = new ArrayList<>();
    // Relación uno a muchos con IRDResultadosAuditoria
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IRDResultadosAuditoria> irdResultadosAuditoria = new ArrayList<>();
    // Relación uno a muchos con IRDDesemProveExternos
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IRDDesemProveExternos> irdDesemProveExternos = new ArrayList<>();
    // Relación uno a muchos con IRDAdecuacionRecursos
    @OneToMany(mappedBy = "informeRevisionDireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IRDAdecuacionRecursos> irdAdecuacionRecursos = new ArrayList<>();



}

