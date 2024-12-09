package com.api.login.Documentos.MejoraContinua.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IntegrantesMejoraContinua")
public class IntegrantesMejoraContinua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntegrantesMejoraContinua;

    private String integrante;
    private String puesto;
    private String firma;

    // Relación muchos a uno con MejoraContinua
    @ManyToOne
    @JoinColumn(name = "idMejoraContinua")
    private MejoraContinua mejoraContinua;
}

