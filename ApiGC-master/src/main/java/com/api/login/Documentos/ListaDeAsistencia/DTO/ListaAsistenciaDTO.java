package com.api.login.Documentos.ListaDeAsistencia.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ListaAsistenciaDTO {

    private Long idListaAsistencia;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    private DatosListaAsistenciaDTO datosListaAsistencia;
    private List<TablaListaAsistenciaDTO> tablaListaAsistenciaList;

}
