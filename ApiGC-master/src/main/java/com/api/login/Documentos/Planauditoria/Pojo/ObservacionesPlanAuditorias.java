package com.api.login.Documentos.Planauditoria.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ObservacionesPlanAuditorias")
public class ObservacionesPlanAuditorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObservacionesPlanAuditorias;

    private String observacion;

    // Relación muchos a uno con PlanAuditoria
    @ManyToOne
    @JoinColumn(name = "idPlanAuditoria")
    private PlanAuditoria planAuditoria;
}

