package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "LDDocTabla")
public class LDDocTabla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLDDocTabla;

    private String nombreReceptor;
    private String puesto;
    private String firma;

    // Relación muchos a uno con ListadoDistribucionDocumentos
    @ManyToOne
    @JoinColumn(name = "idListadoDistribucionDocumentos")
    private ListadoDistribucionDocumentos listadoDistribucionDocumentos;



}

