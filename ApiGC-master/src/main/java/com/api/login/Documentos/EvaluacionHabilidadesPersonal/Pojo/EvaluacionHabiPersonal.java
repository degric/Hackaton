package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EvaluacionHabiPersonal")
public class EvaluacionHabiPersonal {
    @Id
    @Column(name = "idEvaluacionHabiPersonal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluacionHabiPersonal;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

    @OneToOne(mappedBy = "evaluacionHabiPersonal",fetch = FetchType.LAZY)
    private DatosEvaluacionHaPersonal datosEvaluacionHaPersonal;

    @OneToMany(mappedBy = "evaluacionHabiPersonal",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<TablaEvaluacionHaPersonal> tablaEvaluacionHaPersonal;
}
