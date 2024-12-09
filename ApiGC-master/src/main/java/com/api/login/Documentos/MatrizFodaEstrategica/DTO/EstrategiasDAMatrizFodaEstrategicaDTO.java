package com.api.login.Documentos.MatrizFodaEstrategica.DTO;

import lombok.Data;

@Data
public class EstrategiasDAMatrizFodaEstrategicaDTO {

    private Long idEstrategiasDAMatrizFodaEstrategica;
    private String contenido;
    private Long idMatrizFodaEstrategica;  // Campo para relacionar con MatrizFodaEstrategica
}
