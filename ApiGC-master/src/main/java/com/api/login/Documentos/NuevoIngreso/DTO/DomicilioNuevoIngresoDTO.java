package com.api.login.Documentos.NuevoIngreso.DTO;

import lombok.Data;

@Data
public class DomicilioNuevoIngresoDTO {
    private Integer idDomicilioNuevoIngreso;

    private String calleNumero;

    private String colonia;

    private String localidad;

    private String muinicipio;

    private String estado;

    private String cp;

    private Integer idNuevoIngreso;
}
