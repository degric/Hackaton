package com.api.login.Procesos.DTO;

import lombok.Data;

import java.util.List;

@Data
public class DesarrolloProcesoDTO {

    private Long idDesarrolloProceso;

    private String titulo;

    private String contenido;

    private Long idEnProceso;

    private List<SubClausulasProcesoDTO> subClausulas;
}
