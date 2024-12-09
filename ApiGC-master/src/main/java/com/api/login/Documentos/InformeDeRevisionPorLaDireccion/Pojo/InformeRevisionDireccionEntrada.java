package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "InformeRevisionDireccionEntrada")
public class InformeRevisionDireccionEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInformeRevisionDireccionEntrada;

    private String entradas;
    private String directrices;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}

