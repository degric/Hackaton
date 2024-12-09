package com.api.login.ManualDeCalidad.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DocumentosReManualCalidad")
public class DocumentosReManualCalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumentosReManualCalidad;

    private String nombrePunto;

    private Long idSubpunto;

    @ManyToOne
    @JoinColumn(name = "idManualCalidad", nullable = false)
    private ManualCalidad manualCalidad;

    @ManyToOne
    @JoinColumn(name = "idMachoteDocumentos", nullable = false)
    private MachoteDocumentos machoteDocumentos;

}
