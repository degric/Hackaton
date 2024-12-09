package com.api.login.Documentos.PlanAuditorias.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@Table(name = "PlanAuditorias")
public class PlanAuditorias {

    @Id
    @Column(name = "idPlanAuditorias")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanAuditorias;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

    @OneToOne(mappedBy = "planAuditorias")
    private ContenidoPlanAuditorias contenidoPlanAuditorias;

    @OneToMany(mappedBy = "planAuditorias", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<TablaPlanAuditorias> tablaPlanAuditorias;

    @OneToMany(mappedBy = "planAuditorias", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<AuditoresPlanAu> auditoresPlanAus;
}
