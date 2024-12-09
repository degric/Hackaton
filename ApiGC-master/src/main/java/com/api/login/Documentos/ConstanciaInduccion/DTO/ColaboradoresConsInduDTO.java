package com.api.login.Documentos.ConstanciaInduccion.DTO;

import lombok.Data;

@Data
public class ColaboradoresConsInduDTO {

    private Long idColaboradoresConsIndu;
    private String nombre;
    private String puesto;
    private String firma;
    private Long idConstanciaInduccion; // Relación con ConstanciaInduccion
}
