package com.api.login.Documentos.NuevoIngreso.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DatosPersonalesNuevoIngreso")
public class DatosPersonalesNuevoIngreso {

    @Id
    @Column(name = "idDatosPersonalesNuevoIngreso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDatosPersonalesNuevoIngreso;

    private String nombreEmpleado;

    private Date fechaNacimiento;

    private String lugarNacimiento;

    private String edad;

    private String estadoSivil;

    private Date fechaIngreso;

    private String nombreMama;

    private String nombrePapa;

    private String nuHermanos;

    //
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nuevo_ingreso_id", referencedColumnName = "idNuevoIngreso")
    private NuevoIngreso nuevoIngreso;

}
