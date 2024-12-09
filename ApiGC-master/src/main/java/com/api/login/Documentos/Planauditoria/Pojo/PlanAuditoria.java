package com.api.login.Documentos.Planauditoria.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PlanAuditoria")
public class PlanAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanAuditoria;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a muchos con DatosPlanAuditoria
    @OneToMany(mappedBy = "planAuditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatosPlanAuditoria> datosPlanAuditoriaList = new ArrayList<>();

    // Relación uno a muchos con EquipoAuditorPlanAuditoria
    @OneToMany(mappedBy = "planAuditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EquipoAuditorPlanAuditoria> equipoAuditorList = new ArrayList<>();

    @OneToMany(mappedBy = "planAuditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CuerpoPlanAuditoria> cuerpoPlanAuditoriaList = new ArrayList<>();

    // Relación uno a muchos con ObservacionesPlanAuditorias
    @OneToMany(mappedBy = "planAuditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObservacionesPlanAuditorias> observacionesList = new ArrayList<>();

}

