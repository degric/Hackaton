package com.api.login.Documentos.ListaDeVerificacion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ListaVerificacionTabla")
public class ListaVerificacionTabla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListaVerificacionTabla;

    private String numero;
    private String contextoOrganizacion;
    private String marcador;
    private String evidenciasAllasgos;

    // Relación muchos a uno con ListaVerificacion
    @ManyToOne
    @JoinColumn(name = "idListaVerificacion")
    private ListaVerificacion listaVerificacion;
}

