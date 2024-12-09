package com.api.login.Documentos.MinutaDeReunion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MinutaReunionSeguimiento")
public class MinutaReunionSeguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMinutaReunionSeguimiento;

    private String contenido;

    // Relación muchos a uno con MinutaReunion
    @ManyToOne
    @JoinColumn(name = "idMinutaReunion")
    private MinutaReunion minutaReunion;
}

