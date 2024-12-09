package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class IRDResultadosSeguimientoMedicionDTO {

    private Long idIRDResultadosSeguimientoMedicion;
    private String contenido;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}

