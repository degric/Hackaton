package com.api.login.Documentos.MatrizFodaEstrategica.DTO;

import lombok.Data;

@Data
public class EstrategiasFAMatrizFodaEstrategicaDTO {

    private Long idEstrategiasFAMatrizFodaEstrategica;
    private String contenido;
    private Long idMatrizFodaEstrategica;  // Campo para relacionar con MatrizFodaEstrategica
}

