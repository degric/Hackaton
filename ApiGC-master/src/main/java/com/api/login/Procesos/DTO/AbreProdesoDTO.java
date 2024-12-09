package com.api.login.Procesos.DTO;

import lombok.Data;

@Data
public class AbreProdesoDTO {
    private Long idAbreProceso;

    private String abreviaciones;

    private String definicion;

    private Long idEnProceso;
}
