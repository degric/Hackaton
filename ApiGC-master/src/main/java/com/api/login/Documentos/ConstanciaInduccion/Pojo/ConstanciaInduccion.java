package com.api.login.Documentos.ConstanciaInduccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "ConstanciaInduccion")
public class ConstanciaInduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConstanciaInduccion;

    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private LocalDate fecha;

    @OneToMany(mappedBy = "constanciaInduccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InformacionConsIndu> informacionConsIndus;

    // Relación uno a uno con ColaboradorConsInduc
    @OneToOne(mappedBy = "constanciaInduccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private ColaboradorConsInduc colaboradorConsInduc;

    // Relación uno a muchos con ColaboradoresConsIndu
    @OneToMany(mappedBy = "constanciaInduccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ColaboradoresConsIndu> colaboradoresConsIndus;


}
