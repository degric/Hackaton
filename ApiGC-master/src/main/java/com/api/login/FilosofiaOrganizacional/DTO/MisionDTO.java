package com.api.login.FilosofiaOrganizacional.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MisionDTO {

    private Integer idMision;
    private String contenido;
    private LocalDate fecha;
}
