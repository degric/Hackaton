package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class EntradasRevisiondireccion_BDTO {

    private Long idEntradasRevisiondireccion_B;
    private String situacionActual;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}
