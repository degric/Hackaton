package com.api.login.pojo;

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
@Table(name = "lisDisDocumentos")
public class LisDisDocumentos {

    @Id
    @Column(name = "idLisDisDocumentos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLisDisDocumentos;

    private Date fechaEmosion;

    private Date fechaRevision;

    private String coDocumentos;

    private String noRevision;

    private String status;

    private String descripcion;

    //Relaciones

    @OneToMany(mappedBy = "lisDisDocumentos", fetch = FetchType.LAZY)
    private Collection<DocumentosLisDisDo> documentosLisDisDos;

    @OneToMany(mappedBy = "lisDisDocumentos", fetch = FetchType.LAZY)
    private Collection<FirmaLisDisDocumentos> firmaLisDisDocumentos;

}
