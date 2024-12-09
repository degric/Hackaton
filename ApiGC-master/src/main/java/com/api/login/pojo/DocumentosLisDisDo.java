package com.api.login.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DocumentosLisDisDo")
public class DocumentosLisDisDo {

    @Id
    @Column(name = "idDocumentosLisDisDo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocumentosLisDisDo;

    private String area;

    private String coDocumento;

    private String revision;

    private Date fechaImplantacion;

    @ManyToOne
    @JoinColumn(name = "lis_dis_documentos_id", referencedColumnName = "idLisDisDocumentos")
    private LisDisDocumentos lisDisDocumentos;
}
