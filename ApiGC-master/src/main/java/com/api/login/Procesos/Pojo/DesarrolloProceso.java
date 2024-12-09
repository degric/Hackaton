package com.api.login.Procesos.Pojo;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Collection;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "DesarrolloProceso")
public class DesarrolloProceso {

    //no hay cambios


    @Id
    @Column(name = "idDesarrolloProceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesarrolloProceso;

    private String titulo;

    @Column(length = 5000)
    private String contenido;


    @ManyToOne
    @JoinColumn(name = "en_proceso_id", referencedColumnName = "idEnProceso")
    private EnProceso enProceso;

    @OneToMany(mappedBy = "desarrolloProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<SubClausulasProceso> subClausulas;
}
