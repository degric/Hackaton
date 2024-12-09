package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "DetecionNeCaDNC")
public class DetecionNeCaDNC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetecionNeCaDNC;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    @OneToOne(mappedBy = "detecionNeCaDNC", cascade = CascadeType.ALL, orphanRemoval = true)
    private DatosGeneralesDNC datosGeneralesDNC;

    @OneToOne(mappedBy = "detecionNeCaDNC", cascade = CascadeType.ALL, orphanRemoval = true)
    private DatosJefeInmediatoDNC datosJefeInmediatoDNC;

    @OneToMany(mappedBy = "detecionNeCaDNC", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pregunta1DNC> preguntas1DNC;

    @OneToMany(mappedBy = "detecionNeCaDNC", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preguntas2DNC> preguntas2DNC;

}
