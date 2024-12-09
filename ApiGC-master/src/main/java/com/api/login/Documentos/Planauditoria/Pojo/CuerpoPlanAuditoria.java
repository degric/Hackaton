package com.api.login.Documentos.Planauditoria.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CuerpoPlanAuditoria")
public class CuerpoPlanAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuerpoPlanAuditoria;

    private String inicio;
    private String termino;
    private String procesoAuditar;
    private String requisitosNorma;
    private String contraparteAuditada;
    private String auditor;

    // Relación muchos a uno con PlanAuditoria
    @ManyToOne
    @JoinColumn(name = "idPlanAuditoria")
    private PlanAuditoria planAuditoria;
}

