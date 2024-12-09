package com.api.login.Procesos.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ObjetivoProcesoDTO {

    private Long idObjetivoProceso;

    private String contenido;

    private Long idEnProceso;
}
