package com.api.login.Documentos.MejoraContinua.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TablaMejoraContinua")
public class TablaMejoraContinua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaMejoraContinua;

    private String queSeVaHacer;
    private String metaEsperada;

    // Relación muchos a uno con MejoraContinua
    @ManyToOne
    @JoinColumn(name = "idMejoraContinua")
    private MejoraContinua mejoraContinua;
}
