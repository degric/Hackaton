package com.api.login.pojo;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


@Data
@Entity
@Table(name = "trabajoNoConforme")
public class TrabajoNoConforme {

    @Id
    @Column(name = "idTrabajoNoConforme")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(length = 1000)
    private String descripcion;

    @Column(length = 1000)
    private String accionesCorrectivas;

    @Column(length = 500)
    private String involucrados;

    @Column(length = 1000)
    private String seguimiento;

    //pie de paguina

    private String conformidadUsuario;

    private String proveedor;


}
