package com.api.login.Documentos.ListaDeVerificacion.DTO;

import lombok.Data;

@Data
public class ListaVerificacionTablaDTO {

    private Long idListaVerificacionTabla;
    private String numero;
    private String contextoOrganizacion;
    private String marcador;
    private String evidenciasAllasgos;
    private Long idListaVerificacion;  // Relación con ListaVerificacion
}

