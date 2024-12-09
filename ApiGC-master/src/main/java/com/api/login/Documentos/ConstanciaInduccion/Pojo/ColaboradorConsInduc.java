package com.api.login.Documentos.ConstanciaInduccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ColaboradorConsInduc")
public class ColaboradorConsInduc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaboradorConsInduc;

    private String nombre;
    private String firma;

    // Relación uno a uno con ConstanciaInduccion
    @OneToOne
    @JoinColumn(name = "idConstanciaInduccion", nullable = false)
    private ConstanciaInduccion constanciaInduccion;
}
