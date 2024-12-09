package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ListadoDistribucionDocumentos")
public class ListadoDistribucionDocumentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListadoDistribucionDocumentos;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    // Relación uno a muchos con LDDDescricionDocumento
    @OneToMany(mappedBy = "listadoDistribucionDocumentos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LDDDescricionDocumento> lddDescricionDocumentos = new ArrayList<>();

    // Relación uno a muchos con LDDocTabla
    @OneToMany(mappedBy = "listadoDistribucionDocumentos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LDDocTabla> lddDocTablas = new ArrayList<>();
}
