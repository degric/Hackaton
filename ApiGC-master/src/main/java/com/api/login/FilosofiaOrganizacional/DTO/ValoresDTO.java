package com.api.login.FilosofiaOrganizacional.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ValoresDTO {

    private Integer idValores;
    private String contenido;
    private LocalDate fecha;
}
