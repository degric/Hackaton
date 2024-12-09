package com.api.login.Documentos.ListaDeAsistencia.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DatosListaAsistenciaDTO {

    private Long idDatosListaAsistencia;
    private String departamentoCoordinador;
    private String responable;
    private String titulo;
    private LocalDate fecha;
    private Long idListaAsistencia;  // Relación con ListaAsistencia
}
