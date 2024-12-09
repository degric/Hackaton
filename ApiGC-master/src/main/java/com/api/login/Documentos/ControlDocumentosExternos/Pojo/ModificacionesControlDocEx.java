package com.api.login.Documentos.ControlDocumentosExternos.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "ModificacionesControlDocEx")
public class ModificacionesControlDocEx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModificacionesControlDocEx;

    private LocalDate fechaCambio;

    private String edRev;

    private String cambiosRealizadosVerAn;

    // Relación muchos a uno con ControlDocumentosExternos
    @ManyToOne
    @JoinColumn(name = "idControlDocumentosExternos", nullable = false)
    private ControlDocumentosExternos controlDocumentosExternos;
}

