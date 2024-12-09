package com.api.login.Procesos.DTO;

import lombok.Data;

@Data
public class ResponsaProcesoDTO {

    private Long idResponsaProceso;

    private String responsable;

    private String responsabilidades;

    private Long idEnProceso;
}
