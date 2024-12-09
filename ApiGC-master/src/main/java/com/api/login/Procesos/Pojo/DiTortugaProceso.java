package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "DiTortugaProceso")
public class DiTortugaProceso {

    // no se modifica

    @Id
    @Column(name = "idDiTortuga")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiTortuga;

    private String nombreProceso;


    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;
}
