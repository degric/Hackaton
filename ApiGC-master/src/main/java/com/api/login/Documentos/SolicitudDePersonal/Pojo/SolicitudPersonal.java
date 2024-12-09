package com.api.login.Documentos.SolicitudDePersonal.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "SolicitudPersonal")
public class SolicitudPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitudPersonal;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a uno con DatosSolicitudPersonal
    @OneToOne(mappedBy = "solicitudPersonal", cascade = CascadeType.ALL, orphanRemoval = true)
    private DatosSolicitudPersonal datosSolicitudPersonal;
}

