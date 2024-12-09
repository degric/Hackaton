package com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "ProAnualCapacitacion")
public class ProAnualCapacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProAnualCapacitacion;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    @OneToMany(mappedBy = "proAnualCapacitacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TablaProAnualCapacitacion> tablasProAnualCapacitacion;
}
