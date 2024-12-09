package com.api.login.Documentos.ConstanciaInduccion.DTO;

import lombok.Data;

@Data
public class ColaboradorConsInducDTO {

    private Long idColaboradorConsInduc;
    private String nombre;
    private String firma;
    private Long idConstanciaInduccion; // Relación con ConstanciaInduccion
}
