package com.api.login.Procesos.Pojo;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "SubSubClausulasProceso")
public class SubSubClausulasProceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubSubClausulasProceso;

    private String titulo;

    @Column(length = 4000)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idSubClausulasProceso", nullable = false)
    private SubClausulasProceso subClausulasProceso;
}

