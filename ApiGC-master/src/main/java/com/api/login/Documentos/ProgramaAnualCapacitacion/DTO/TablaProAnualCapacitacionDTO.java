package com.api.login.Documentos.ProgramaAnualCapacitacion.DTO;

import lombok.Data;

@Data
public class TablaProAnualCapacitacionDTO {

    private Long idTablaProAnualCapacitacion;
    private String titulo;
    private String perDepartamento;
    private String tipo;
    private String capacitador;
    private String duracion;
    private String estatus;
    private String fecha;
    private Long idProAnualCapacitacion; // Relación con ProAnualCapacitacion
}
