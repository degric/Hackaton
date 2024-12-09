package com.api.login.Documentos.ListaDeVerificacion.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ListaVerificacionDTO {

    private Long idListaVerificacion;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    // Lista de tablas de la lista de verificación
    private List<ListaVerificacionTablaDTO> listaVerificacionTablas;
}

