package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity

@Table(name = "HisRevisionesProceso")
public class HisRevisionesProceso {

    //se queda igual

    @Id
    @Column(name = "idHisRevisionProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHisRevisionProceso;

    private String numeroRevision;

    private LocalDate fecha;

    @Column(length = 1000)
    private String seccionAfectada;

    private String efectuadoPor;

    private LocalDate fechaEjecucion;

    @ManyToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;
}
