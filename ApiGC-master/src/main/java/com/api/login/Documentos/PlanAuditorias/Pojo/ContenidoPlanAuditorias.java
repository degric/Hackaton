package com.api.login.Documentos.PlanAuditorias.Pojo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "ContenidoPlanAuditorias")
public class ContenidoPlanAuditorias {

    @Id
    @Column(name = "idContenidoPlanAuditorias")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContenidoPlanAuditorias;

    private String noAuditoria;

    private Date fecha;

    @Column(length = 1000)
    private String areas;

    @Column(length = 1000)
    private String objetivos;

    @Column(length = 1000)
    private String alcance;

    @Column(length = 1000)
    private String criterios;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_encabezado", referencedColumnName = "idPlanAuditorias")
    private PlanAuditorias planAuditorias;
}
