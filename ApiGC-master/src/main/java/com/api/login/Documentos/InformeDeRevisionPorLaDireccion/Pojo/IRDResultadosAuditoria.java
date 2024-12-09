package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IRDResultadosAuditoria")
public class IRDResultadosAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIRDResultadosAuditoria;

    private String contenido;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}
