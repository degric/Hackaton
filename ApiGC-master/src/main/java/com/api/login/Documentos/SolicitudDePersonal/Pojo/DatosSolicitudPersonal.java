package com.api.login.Documentos.SolicitudDePersonal.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "DatosSolicitudPersonal")
public class DatosSolicitudPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDatosSolicitudPersonal;

    private String nombre;
    private String cargo;
    private String areaActual;
    private LocalDate fechaSolicitud;
    private String puestoSolicitado;
    private String areaNueva;
    private String numeroVacantes;
    private LocalDate fechaPrevista;
    private String motivotipoContrato;
    private String estatus;
    private String especifique;
    //prueba

    // Relación uno a uno con SolicitudPersonal
    @OneToOne
    @JoinColumn(name = "idSolicitudPersonal", referencedColumnName = "idSolicitudPersonal")
    private SolicitudPersonal solicitudPersonal;
}

