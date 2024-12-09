package com.api.login.Documentos.NuevoIngreso.Pojo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DatPersonalNuevoIngreso")
public class DatPersonalNuevoIngreso {

    @Id
    @Column(name = "idDatPersonalNuevoIngreso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDatPersonalNuevoIngreso;

    private String rfc;

    private String tipoSangre;

    private String noTelefono;

    private String noPerTelefono;

    private String noSeguroSocial;

    private String liConducir;

    private String noLicencia;

    private String email;

    private String nivelEstudios;

    private String pasatiempos;

    //
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nuevo_ingreso_id", referencedColumnName = "idNuevoIngreso")
    private NuevoIngreso nuevoIngreso;
}
