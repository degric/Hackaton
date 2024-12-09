package com.api.login.Procesos.Pojo;

import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "DoReferenciaProceso")
public class DoReferenciaProceso {

    //no hay cambios

    @Id
    @Column(name = "idDoReferenciaProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoReferenciaProceso;

    private String coDocumento;

    private String nombreDocumento;

    @ManyToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;
}
