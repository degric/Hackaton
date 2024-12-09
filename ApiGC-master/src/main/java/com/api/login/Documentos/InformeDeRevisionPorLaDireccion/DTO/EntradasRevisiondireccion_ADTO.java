package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class EntradasRevisiondireccion_ADTO {

    private Long idEntradasRevisiondireccion_A;
    private String situacionActual;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}
