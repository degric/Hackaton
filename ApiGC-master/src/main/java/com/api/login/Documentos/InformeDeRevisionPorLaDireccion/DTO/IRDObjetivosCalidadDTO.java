package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class IRDObjetivosCalidadDTO {

    private Long idIRDObjetivosCalidad;
    private String contenido;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}
