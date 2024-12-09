package com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TablaProAuInternas")
public class TablaProAuInternas {

    @Id
    @Column(name = "idTablaProAuInternas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTablaProAuInternas;

    private String areaAuditada;

    private String mes1AuIn;

    private String mes2AuIn;

    private String mesAuEx;

    @ManyToOne
    @JoinColumn(name = "programa_au_internas_id", referencedColumnName = "idProgramaAuditoriasInternas")
    private ProgramaAuditoriasInternas programaAuditoriasInternas;
}
