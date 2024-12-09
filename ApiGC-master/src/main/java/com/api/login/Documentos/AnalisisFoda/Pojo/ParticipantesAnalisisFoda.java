package com.api.login.Documentos.AnalisisFoda.Pojo;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "ParticipantesAnalisisFoda")
public class ParticipantesAnalisisFoda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParticipantesAnalisisFoda;

    private String nombre;
    private String puesto;

    @ManyToOne
    @JoinColumn(name = "idAnalisisFoda", nullable = false)
    private AnalisisFoda analisisFoda;
}
