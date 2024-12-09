package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IRDAdecuacionRecursos")
public class IRDAdecuacionRecursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIRDAdecuacionRecursos;

    private String situacionActual;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}

