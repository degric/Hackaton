package com.api.login.Procesos.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "SubClausulasProceso")
public class SubClausulasProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubClausulasProceso")
    private Long idSubClausulasProceso;

    private String titulo;

    @Column(length = 4000)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idDesarrolloProceso", nullable = false)
    private DesarrolloProceso desarrolloProceso;

    @OneToMany(mappedBy = "subClausulasProceso", cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<SubSubClausulasProceso> subSubClausulasProceso;

}
