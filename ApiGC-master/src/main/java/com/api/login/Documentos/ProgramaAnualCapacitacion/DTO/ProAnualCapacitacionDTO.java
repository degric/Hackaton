package com.api.login.Documentos.ProgramaAnualCapacitacion.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProAnualCapacitacionDTO {

    private Long idProAnualCapacitacion;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    private List<TablaProAnualCapacitacionDTO> tablasProAnualCapacitacion;
}
