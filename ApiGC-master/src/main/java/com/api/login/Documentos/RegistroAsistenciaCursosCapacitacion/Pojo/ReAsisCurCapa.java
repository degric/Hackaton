package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo;

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
@Table(name = "ReAsisCurCapa")
public class ReAsisCurCapa {

    @Id
    @Column(name = "idReAsisCurCapa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReAsisCurCapa;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

    @OneToOne(mappedBy = "reAsisCurCapa", fetch = FetchType.LAZY)
    private InformacionReAsisCurCapa informacionReAsisCurCapa;

    @OneToMany(mappedBy = "reAsisCurCapa", fetch = FetchType.LAZY)
    private Collection<TablaReAsisCurCapa> tablaReAsisCurCapas;

}
