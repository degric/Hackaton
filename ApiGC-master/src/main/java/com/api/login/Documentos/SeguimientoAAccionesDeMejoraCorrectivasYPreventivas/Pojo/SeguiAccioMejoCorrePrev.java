package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "SeguiAccioMejoCorrePrev")
public class SeguiAccioMejoCorrePrev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguiAccioMejoCorrePrev;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Relación uno a muchos con SeAcMeCoPrTabla
    @OneToMany(mappedBy = "seguiAccioMejoCorrePrev", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeAcMeCoPrTabla> seAcMeCoPrTablas = new ArrayList<>();
}

