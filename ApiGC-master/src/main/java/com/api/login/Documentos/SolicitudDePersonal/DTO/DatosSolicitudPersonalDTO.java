package com.api.login.Documentos.SolicitudDePersonal.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DatosSolicitudPersonalDTO {

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
    private Long idSolicitudPersonal;  // Relación con SolicitudPersonal
}
