package com.api.login.Documentos.ListaDeAsistencia.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TablaListaAsistencia")
public class TablaListaAsistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaListaAsistencia;

    private String nombreParticipante;
    private String puesto;
    private String firma;

    // Relación muchos a uno con ListaAsistencia
    @ManyToOne
    @JoinColumn(name = "idListaAsistencia")
    private ListaAsistencia listaAsistencia;
}

