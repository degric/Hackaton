package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class IRDResultadosAuditoriaDTO {

    private Long idIRDResultadosAuditoria;
    private String contenido;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}
