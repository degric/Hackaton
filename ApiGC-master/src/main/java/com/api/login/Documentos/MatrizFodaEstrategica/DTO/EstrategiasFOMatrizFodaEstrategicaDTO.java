package com.api.login.Documentos.MatrizFodaEstrategica.DTO;

import lombok.Data;

@Data
public class EstrategiasFOMatrizFodaEstrategicaDTO {

    private Long idEstrategiasFOMatrizFodaEstrategica;
    private String contenido;
    private Long idMatrizFodaEstrategica;  // Campo para relacionar con MatrizFodaEstrategica
}

