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
@Table(name = "DatosSolicitudCotizacion")
public class DatosSolicitudCotizacion {

    @Id
    @Column(name = "idDatosSolicitudCotizacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDatosSolicitudCotizacion;

    private String municipio;

    private String estado;

    private Date fecha;

    private String solicitud;

    private String nombre;

    private String direccion;

    private String telefono;

    private String celular;

    private String nombreAtencion;

    private String puesto;

    private String correo;

    private String descripcionSolicitado;

    //
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "solicitud_id", referencedColumnName = "idSolicitudCotizacion")
    private SolicitudCotizacion solicitudCotizacion;

}
