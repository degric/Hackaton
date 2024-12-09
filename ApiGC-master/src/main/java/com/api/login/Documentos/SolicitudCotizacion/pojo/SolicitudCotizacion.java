package com.api.login.Documentos.SolicitudCotizacion.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SolicitudCotizacion")
public class SolicitudCotizacion {

    @Id
    @Column(name = "idSolicitudCotizacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitudCotizacion;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

    private String nomSolicita;

    //,fetch = FetchType.LAZY
    @OneToOne(mappedBy = "solicitudCotizacion")
    private CondicionesSolicitudCotizacion condicionesSolicitudCotizacions;

    //, fetch = FetchType.LAZY
    @OneToOne(mappedBy = "solicitudCotizacion")
    private DatosSolicitudCotizacion datosSolicitudCotizacion;
}
