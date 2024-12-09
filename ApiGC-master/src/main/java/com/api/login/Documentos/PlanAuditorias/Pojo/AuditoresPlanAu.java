package com.api.login.Documentos.PlanAuditorias.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "AuditoresPlanAu")
public class AuditoresPlanAu {

    @Id
    @Column(name = "idAuditoresPlanAu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuditoresPlanAu;

    private String auditor;

    @ManyToOne
    @JoinColumn(name = "id_encabezado", referencedColumnName = "idPlanAuditorias")
    private PlanAuditorias planAuditorias;
}
