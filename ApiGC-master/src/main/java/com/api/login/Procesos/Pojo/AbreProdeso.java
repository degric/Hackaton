package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "AbreProdeso")
public class AbreProdeso {

    //se queda igual

    @Id
    @Column(name = "idAbreProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbreProceso;

    private String abreviaciones;

    @Column(length = 5000)
    private String definicion;

    @ManyToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;
}
