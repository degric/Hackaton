package com.api.login.Documentos.ControlDocumentosExternos.Pojo;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "ControlDocumentosExternos")
public class ControlDocumentosExternos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idControlDocumentosExternos;

    private String coDocumento;

    private String noRevision;

    private LocalDate fechaEmicion;

    private LocalDate fechaRevision;

    private String area;

    private String seccion;

    private LocalDate fecha;

    // Relación uno a muchos con TablaControlDocumentosExternos
    @OneToMany(mappedBy = "controlDocumentosExternos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablaControlDocumentosExternos> tablasControlDocumentosExternos;

    @OneToMany(mappedBy = "controlDocumentosExternos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModificacionesControlDocEx> modificacionesControlDocExes;

}

