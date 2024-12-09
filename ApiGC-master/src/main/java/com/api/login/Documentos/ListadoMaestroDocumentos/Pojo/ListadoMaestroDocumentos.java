package com.api.login.Documentos.ListadoMaestroDocumentos.Pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "ListadoMaestroDocumentos")
public class ListadoMaestroDocumentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListadoMaestroDocumentos;

    private String coDocumento;

    private String noRevision;

    private LocalDate fechaEmicion;

    private LocalDate fechaRevision;

    // Relación uno a muchos con TablaLisMaDocumentosProcesos
    @OneToMany(mappedBy = "listadoMaestroDocumentos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablaLisMaDocumentosProcesos> procesos = new ArrayList<>();


    @OneToMany(mappedBy = "listadoMaestroDocumentos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablaLisMaDocumentosFormatos> formatos = new ArrayList<>();

    @OneToMany(mappedBy = "listadoMaestroDocumentos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablaLisMaDocumentosAnexos> anexos = new ArrayList<>();
}

