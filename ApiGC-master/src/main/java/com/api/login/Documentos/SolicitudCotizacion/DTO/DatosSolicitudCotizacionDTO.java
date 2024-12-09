package com.api.login.Documentos.SolicitudCotizacion.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class DatosSolicitudCotizacionDTO {
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

    private Integer idSolicitudCotizacion;
}
