package com.api.login.Procesos.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AlcanceProcesoDTO {

    private Long idAlcanceProceso;

    private String contenido;

    private Long idEnProceso;
}
