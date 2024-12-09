package com.api.login.Documentos.ListaDeAsistencia.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "DatosListaAsistencia")
public class DatosListaAsistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDatosListaAsistencia;

    private String departamentoCoordinador;
    private String responable;
    private String titulo;
    private LocalDate fecha;

    // Relación uno a uno con ListaAsistencia
    @OneToOne
    @JoinColumn(name = "idListaAsistencia", referencedColumnName = "idListaAsistencia")
    private ListaAsistencia listaAsistencia;
}

