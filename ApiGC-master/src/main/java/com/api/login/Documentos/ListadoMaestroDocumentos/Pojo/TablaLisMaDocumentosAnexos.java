package com.api.login.Documentos.ListadoMaestroDocumentos.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "TablaLisMaDocumentosAnexos")
public class TablaLisMaDocumentosAnexos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaLisMaDocumentosFormatosAnexos;

    private String codigo;
    private String nombredocumento;
    private String departamento;
    private String responsable;
    private String noRevision;
    private LocalDate elaborado;
    private LocalDate revisado;
    private LocalDate modificado;

    // Relación muchos a uno con ListadoMaestroDocumentos
    @ManyToOne
    @JoinColumn(name = "idListadoMaestroDocumentos")
    private ListadoMaestroDocumentos listadoMaestroDocumentos;
}

