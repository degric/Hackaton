package com.api.login.Documentos.PlanAuditorias.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TablaPlanAuditorias")
public class TablaPlanAuditorias {
    @Id
    @Column(name = "idTablaPlanAuditorias")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaPlanAuditorias;

    private String horario;

    private String horaFin;

    private String requisito;

    private String auditor;

    private String requisito1;

    private String auditor1;

    private String requisito2;

    private String auditor2;

    @ManyToOne
    @JoinColumn(name = "id_encabezado", referencedColumnName = "idPlanAuditorias")
    private PlanAuditorias planAuditorias;

    //preguntar por que se repite la parte de requisito y auditor 3 veces?
}
