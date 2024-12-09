package com.api.login.Documentos.ConstanciaInduccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ColaboradoresConsIndu")
public class ColaboradoresConsIndu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaboradoresConsIndu;

    private String nombre;
    private String puesto;
    private String firma;

    // Relación muchos a uno con ConstanciaInduccion
    @ManyToOne
    @JoinColumn(name = "idConstanciaInduccion", nullable = false)
    private ConstanciaInduccion constanciaInduccion;
}

