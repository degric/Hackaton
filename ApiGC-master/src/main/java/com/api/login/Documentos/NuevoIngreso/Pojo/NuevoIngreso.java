package com.api.login.Documentos.NuevoIngreso.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NuevoIngreso")
public class NuevoIngreso {

    @Id
    @Column(name = "idNuevoIngreso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNuevoIngreso;

    private String coDocumento;

    private String noRevision;

    private Date fechaEmicion;

    private Date fechaRevision;

    @OneToOne(mappedBy = "nuevoIngreso")
    private DatosPersonalesNuevoIngreso datosPersonalesNuevoIngreso;

    @OneToOne(mappedBy = "nuevoIngreso")
    private DatPersonalNuevoIngreso datPersonalNuevoIngreso;

    @OneToOne(mappedBy = "nuevoIngreso")
    private DomicilioNuevoIngreso domicilioNuevoIngreso;

    @OneToMany(mappedBy = "nuevoIngreso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<TraAnNuevoIngreso> traAnNuevoIngresos;

}
