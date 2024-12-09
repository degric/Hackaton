package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "ObjetivoProceso")
public class ObjetivoProceso {

    //no hay mdificaciones

    @Id
    @Column(name = "idObjetivoProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjetivoProceso;

    @Column(length = 5000)
    private String contenido;

    @OneToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;
}
