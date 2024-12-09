package com.api.login.Documentos.ConstanciaInduccion.DTO;

import lombok.Data;

@Data
public class InformacionConsInduDTO {

    private Long idInformacionConsIndu;
    private String info;
    private String respuesta;
    private Long idConstanciaInduccion; // Relación con ConstanciaInduccion
}
