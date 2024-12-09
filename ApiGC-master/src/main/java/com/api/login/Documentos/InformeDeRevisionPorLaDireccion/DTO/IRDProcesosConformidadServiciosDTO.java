package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class IRDProcesosConformidadServiciosDTO {

    private Long idIRDProcesosConformidadServicios;
    private String proceso;
    private String indicador;
    private String meta;
    private String tendencia;
    private String status;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}

