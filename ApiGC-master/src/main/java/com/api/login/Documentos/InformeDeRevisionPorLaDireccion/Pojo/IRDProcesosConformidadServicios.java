package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IRDProcesosConformidadServicios")
public class IRDProcesosConformidadServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIRDProcesosConformidadServicios;

    private String proceso;
    private String indicador;
    private String meta;
    private String tendencia;
    private String status;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}

