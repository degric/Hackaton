package com.api.login.Documentos.MatrizFodaEstrategica.Pojo;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "MatrizFodaEstrategica")
public class MatrizFodaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatrizFodaEstrategica;

    private String coDocumento;

    private String noRevision;

    private LocalDate fechaEmicion;

    private LocalDate fechaRevision;

    private LocalDate fechaRegistro;

    // Relación uno a muchos con FortalezasMatrizFodaEstrategica
    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FortalezasMatrizFodaEstrategica> fortalezas;

    // Relación uno a muchos con DebilidadesMatrizFodaEstrategica
    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DebilidadesMatrizFodaEstrategica> debilidades;

    // Relación uno a muchos con OportunidadesMatrizFodaEstrategica
    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OportunidadesMatrizFodaEstrategica> oportunidades;

    // Relación uno a muchos con EstrategiasFOMatrizFodaEstrategica
    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstrategiasFOMatrizFodaEstrategica> estrategiasFO;


    // Relación uno a muchos con EstrategiasDOMatrizFodaEstrategica
    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstrategiasDOMatrizFodaEstrategica> estrategiasDO;

    // Relaciones anteriores (fortalezas, debilidades, etc.)

    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AmenazasMatrizFodaEstrategica> amenazas;

    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstrategiasFAMatrizFodaEstrategica> estrategiasFA;


    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstrategiasDAMatrizFodaEstrategica> estrategiasDA;

    @OneToMany(mappedBy = "matrizFodaEstrategica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanAccionEstrategiasFoda> planesAccion;

}

