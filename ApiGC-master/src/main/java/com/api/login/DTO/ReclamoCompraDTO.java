package com.api.login.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class ReclamoCompraDTO {

    private Integer idReclamoCompra;

    //encabezado
    private String coDocumento;

    private String numeroRevision;

    private Date fechaEmision;

    private Date fechaRevision;

    //contenido
    private Date fecha;

    private String proveedor;

    //nombre de quien atiende la reclamacion
    private String nomAtiReclamo;

    private String casua;

    private String accionTomada;

    private Date fechaCierre;

    private String elaboro;

    private String autorizo;
}
