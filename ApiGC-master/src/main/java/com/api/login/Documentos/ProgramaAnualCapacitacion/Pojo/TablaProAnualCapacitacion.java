package com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TablaProAnualCapacitacion")
public class TablaProAnualCapacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaProAnualCapacitacion;

    private String titulo;
    private String perDepartamento;
    private String tipo;
    private String capacitador;
    private String duracion;
    private String estatus;
    private String fecha;

    // Relación muchos a uno con ProAnualCapacitacion
    @ManyToOne
    @JoinColumn(name = "idProAnualCapacitacion", nullable = false)
    private ProAnualCapacitacion proAnualCapacitacion;
}
