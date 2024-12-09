package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "ResponsaProceso")
public class ResponsaProceso {

    //no se modifica

    @Id
    @Column(name = "idResponsaProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsaProceso;

    private String responsable;

    @Column(length = 5000)
    private String responsabilidades;

    @ManyToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;
}
