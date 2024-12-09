package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IRDObjetivosCalidad")
public class IRDObjetivosCalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIRDObjetivosCalidad;

    private String contenido;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}
