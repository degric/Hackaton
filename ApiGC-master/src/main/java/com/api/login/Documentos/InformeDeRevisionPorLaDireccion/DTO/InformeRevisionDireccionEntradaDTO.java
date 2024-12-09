package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class InformeRevisionDireccionEntradaDTO {

    private Long idInformeRevisionDireccionEntrada;
    private String entradas;
    private String directrices;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}
