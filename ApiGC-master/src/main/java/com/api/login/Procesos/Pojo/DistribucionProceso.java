package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "DistribucionProceso")
public class DistribucionProceso {


    //se queda igual

    @Id
    @Column(name = "idDisProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisProceso;

    @Column(length = 5000)
    private String contenido;

    @OneToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;

}
