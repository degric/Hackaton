package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IRDNoConformidadesAcCorrectivas")
public class IRDNoConformidadesAcCorrectivas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIRDNoConformidadesAcCorrectivas;

    private String tipo;
    private String reportadas;
    private String enSeguimiento;
    private String implementadas;
    private String cerradas;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}

