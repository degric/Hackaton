package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DatosEvaluacionHaPersonal")
public class DatosEvaluacionHaPersonal {

    @Id
    @Column(name = "idDatosEvaluacionHaPersonal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDatosEvaluacionHaPersonal;

    private String nombre;

    private String puesto;

    private Date fechaEvaluacion;

    //viene de resultados
    private String evaluador;

    private Integer promedio;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_encabezado", referencedColumnName = "idEvaluacionHabiPersonal")
    private EvaluacionHabiPersonal evaluacionHabiPersonal;
}
