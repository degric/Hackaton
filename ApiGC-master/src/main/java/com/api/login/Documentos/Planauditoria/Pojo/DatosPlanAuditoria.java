package com.api.login.Documentos.Planauditoria.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "DatosPlanAuditoria")
public class DatosPlanAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDatosPlanAuditoria;

    private String objetivoAuditoria;
    private String alcanceAuditoria;
    private String criteriosAuditorias;
    private LocalDate fechaElaboracion;
    private String noAuditoria;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;

    // Relación muchos a uno con PlanAuditoria
    @ManyToOne
    @JoinColumn(name = "idPlanAuditoria")
    private PlanAuditoria planAuditoria;
}
