package com.api.login.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;

@Data
public class TrabajoNoConformeDTO {
    private Integer idTrabajoNoConforme;

    //encabezado
    private Date fechaEmision;

    private Date fechaRevision;

    private String nombreEmpresa;

    private Date fechaDeNoConformidad;

    private Date fechaCierre;

    private String noRevision;

    private String codigoDocumento;

    //Contenido
    private String nombre;

    private String importancia;

    private String descripcion;

    private String accionesCorrectivas;

    private String involucrados;

    private String seguimiento;

    //pie de paguina

    private String conformidadUsuario;

    private String proveedor;
}
