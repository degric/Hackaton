package com.api.login.Documentos.MinutaDeReunion.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

@Data
@Entity
@Table(name = "MinuReunParticipantes")
public class MinuReunParticipantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMinuReunParticipantes;

    private String nombre;

    // Relación muchos a uno con MinutaReunion
    @ManyToOne
    @JoinColumn(name = "idMinutaReunion")
    private MinutaReunion minutaReunion;
}

