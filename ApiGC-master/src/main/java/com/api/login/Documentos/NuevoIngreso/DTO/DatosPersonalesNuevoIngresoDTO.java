package com.api.login.Documentos.NuevoIngreso.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class DatosPersonalesNuevoIngresoDTO {
    private Integer idDatosPersonalesNuevoIngreso;

    private String nombreEmpleado;

    private Date fechaNacimiento;

    private String lugarNacimiento;

    private String edad;

    private String estadoSivil;

    private Date fechaIngreso;

    private String nombreMama;

    private String nombrePapa;

    private String nuHermanos;

    private Integer idNuevoIngreso;
}
