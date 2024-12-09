package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EntradasRevisiondireccion_C")
public class EntradasRevisiondireccion_C {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntradasRevisiondireccion_C;

    private String situacionActual;
    private String retroalimentacion;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}
