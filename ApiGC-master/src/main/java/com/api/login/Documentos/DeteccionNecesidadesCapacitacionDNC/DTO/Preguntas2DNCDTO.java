package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO;

import lombok.Data;

@Data
public class Preguntas2DNCDTO {

    private Long idPreguntas2DNC;
    private String contenido1;
    private String contenido2;
    private String contenido3;
    private Long idDetecionNeCaDNC; // Relación con DetecionNeCaDNC
}
