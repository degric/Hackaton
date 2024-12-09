package com.api.login.Documentos.ListaDeVerificacion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ListaVerificacion")
public class ListaVerificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListaVerificacion;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a muchos con ListaVerificacionTabla
    @OneToMany(mappedBy = "listaVerificacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ListaVerificacionTabla> listaVerificacionTablas = new ArrayList<>();

}
