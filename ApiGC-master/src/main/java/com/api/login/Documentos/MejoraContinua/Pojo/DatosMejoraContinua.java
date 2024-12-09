package com.api.login.Documentos.MejoraContinua.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DatosMejoraContinua")
public class DatosMejoraContinua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDatosMejoraContinua;

    private String alcance;
    private String numeroControl;
    private String objetivo;
    private String origenMejora;
    private String descripcionAccion;
    private String descriocion;
    private String cuantificacion;
    private String periodo;
    private String tiempoInicial;
    private String tiempoFinal;
    private String resultado;

    // Relación uno a uno con MejoraContinua
    @OneToOne
    @JoinColumn(name = "idMejoraContinua", referencedColumnName = "idMejoraContinua")
    private MejoraContinua mejoraContinua;
}
