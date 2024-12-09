package com.api.login.Procesos.DTO;

import lombok.Data;

import java.util.List;

@Data
public class SubClausulasProcesoDTO {

    private Long idSubClausulasProceso;
    private String titulo;
    private String contenido;
    private Long idDesarrolloProceso;
    // ID del desarrollo padre

    private List<SubSubClausulasProcesoDTO> subSubClausulas;
}
