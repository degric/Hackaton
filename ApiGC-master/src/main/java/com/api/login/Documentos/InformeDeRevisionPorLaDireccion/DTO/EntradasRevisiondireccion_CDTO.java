package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class EntradasRevisiondireccion_CDTO {

    private Long idEntradasRevisiondireccion_C;
    private String situacionActual;
    private String retroalimentacion;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}

