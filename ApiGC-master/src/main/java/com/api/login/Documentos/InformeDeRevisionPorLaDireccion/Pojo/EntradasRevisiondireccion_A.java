package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EntradasRevisiondireccion_A")
public class EntradasRevisiondireccion_A {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntradasRevisiondireccion_A;

    private String situacionActual;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}

