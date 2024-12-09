package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "LDDDescricionDocumento")
public class LDDDescricionDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLDDDescricionDocumento;

    private String descripcion;
    private String documento;
    private String area;
    private String codigoDocumento;
    private String revision;
    private LocalDate fechaImplantacion;

    // Relación muchos a uno con ListadoDistribucionDocumentos
    @ManyToOne
    @JoinColumn(name = "idListadoDistribucionDocumentos")
    private ListadoDistribucionDocumentos listadoDistribucionDocumentos;
}

