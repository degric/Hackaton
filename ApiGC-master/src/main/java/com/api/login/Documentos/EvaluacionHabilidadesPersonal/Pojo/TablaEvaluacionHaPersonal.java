package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TablaEvaluacionHaPersonal")
public class TablaEvaluacionHaPersonal {

    @Id
    @Column(name = "idTablaEvaluacionHaPersonal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaEvaluacionHaPersonal;

    private String puntoEvaluar;

    //no importa el resultado
    private String opcion;

    @ManyToOne
    @JoinColumn(name = "id_encabezado", referencedColumnName = "idEvaluacionHabiPersonal")
    private EvaluacionHabiPersonal evaluacionHabiPersonal;

}
