package com.api.login.Documentos.MatrizFodaEstrategica.DTO;

import lombok.Data;

@Data
public class DebilidadesMatrizFodaEstrategicaDTO {

    private Long idDebilidadesMatrizFodaEstrategica;
    private String contenido;
    private Long idMatrizFodaEstrategica;  // Campo para relacionar con MatrizFodaEstrategica
}

