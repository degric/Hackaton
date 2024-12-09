package com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProgramaAuditoriasInternas")
public class ProgramaAuditoriasInternas {

    @Id
    @Column(name = "idProgramaAuditoriasInternas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgramaAuditoriasInternas;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

    private String anio;

    @OneToMany(mappedBy = "programaAuditoriasInternas", fetch = FetchType.LAZY)
    private Collection<TablaProAuInternas> tablaProAuInternas;
    @OneToOne(mappedBy = "programaAuditoriasInternas")
    private ObservacionesProAuInternas observacionesProAuInternas;


}
