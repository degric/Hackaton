package com.api.login.Documentos.ControlDocumentosExternos.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "TablaControlDocumentosExternos")
public class TablaControlDocumentosExternos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaControlDocumentosExternos;

    private String numero;

    private String externo;

    private String codigo;

    private String nombreDocumento;

    private String revision;

    private LocalDate fechaEmocion;

    private LocalDate fechaRevision;

    private LocalDate fechaUltimoCambio;

    @ManyToOne
    @JoinColumn(name = "idControlDocumentosExternos", nullable = false)
    private ControlDocumentosExternos controlDocumentosExternos;
}

