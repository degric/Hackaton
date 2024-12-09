package com.api.login.Documentos.Planauditoria.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EquipoAuditorPlanAuditoria")
public class EquipoAuditorPlanAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipoAuditorPlanAuditoria;

    private String auditorLider;
    private String auditores;
    private String auditoresEntrenamiento;

    // Relación muchos a uno con PlanAuditoria
    @ManyToOne
    @JoinColumn(name = "idPlanAuditoria")
    private PlanAuditoria planAuditoria;
}

