package com.api.login.Documentos.ConstanciaInduccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "InformacionConsIndu")
public class InformacionConsIndu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInformacionConsIndu;

    private String info;
    private String respuesta;

    // Relación muchos a uno con ConstanciaInduccion
    @ManyToOne
    @JoinColumn(name = "idConstanciaInduccion", nullable = false)
    private ConstanciaInduccion constanciaInduccion;
}
