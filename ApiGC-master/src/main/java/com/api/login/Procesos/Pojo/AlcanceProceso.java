package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "AlcanceProceso")
public class AlcanceProceso {


    //no se modifica

    @Id
    @Column(name = "idAlcanceProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlcanceProceso;

    @Column(length = 5000)
    private String contenido;

    @OneToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;

}
