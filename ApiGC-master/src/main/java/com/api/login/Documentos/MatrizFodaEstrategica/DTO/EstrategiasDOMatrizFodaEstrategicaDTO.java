package com.api.login.Documentos.MatrizFodaEstrategica.DTO;

import lombok.Data;

@Data
public class EstrategiasDOMatrizFodaEstrategicaDTO {

    private Long idEstrategiasDOMatrizFodaEstrategica;
    private String contenido;
    private Long idMatrizFodaEstrategica;  // Campo para relacionar con MatrizFodaEstrategica
}

