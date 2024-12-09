package com.api.login.Documentos.MatrizFodaEstrategica.Pojo;

import java.time.LocalDate;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "PlanAccionEstrategiasFoda")
public class PlanAccionEstrategiasFoda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanAccionEstrategiasFoda;

    private String tipo;
    private String estrategias;
    private String objetivo;
    private String folio;
    private String responsable;
    private LocalDate fechaMeta;

    @ManyToOne
    @JoinColumn(name = "idMatrizFodaEstrategica", nullable = false)
    private MatrizFodaEstrategica matrizFodaEstrategica;
}

