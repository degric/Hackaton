package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class IRDAdecuacionRecursosDTO {

    private Long idIRDAdecuacionRecursos;
    private String situacionActual;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}
