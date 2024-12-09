package com.api.login.Documentos.ListaDeAsistencia.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ListaAsistencia")
public class ListaAsistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListaAsistencia;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a uno con DatosListaAsistencia
    @OneToOne(mappedBy = "listaAsistencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private DatosListaAsistencia datosListaAsistencia;

    // Relación uno a muchos con TablaListaAsistencia
    @OneToMany(mappedBy = "listaAsistencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablaListaAsistencia> tablaListaAsistenciaList = new ArrayList<>();
}

