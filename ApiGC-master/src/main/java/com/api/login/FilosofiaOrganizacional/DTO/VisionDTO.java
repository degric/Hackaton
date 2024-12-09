package com.api.login.FilosofiaOrganizacional.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class VisionDTO {

    private Integer idVision;
    private String contenido;
    private LocalDate fecha;
}

