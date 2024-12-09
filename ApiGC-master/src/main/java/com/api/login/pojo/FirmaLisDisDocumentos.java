package com.api.login.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FirmaLisDisDocumentos")
public class FirmaLisDisDocumentos {
    @Id
    @Column(name = "idFirmaLisDisDocumentos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFirmaLisDisDocumentos;

    private String area;

    private String nombre;

    private String firma;

    @ManyToOne
    @JoinColumn(name = "lis_dis_documentos_id", referencedColumnName = "idLisDisDocumentos")
    private LisDisDocumentos lisDisDocumentos;
}
