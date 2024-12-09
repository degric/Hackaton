package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "SeAcMeCoPrTabla")
public class SeAcMeCoPrTabla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeAcMeCoPrTabla;

    private String hallazgo;
    private String evidenciasObservadas;
    private String responsableAreaImplantacion;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private String avance;
    private String revisionValoracion;

    // Relación muchos a uno con SeguiAccioMejoCorrePrev
    @ManyToOne
    @JoinColumn(name = "idSeguiAccioMejoCorrePrev")
    private SeguiAccioMejoCorrePrev seguiAccioMejoCorrePrev;
}

