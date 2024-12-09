package com.api.login.Documentos.NuevoIngreso.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DomicilioNuevoIngreso")
public class DomicilioNuevoIngreso {

    @Id
    @Column(name = "idDomicilioNuevoIngreso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDomicilioNuevoIngreso;

    private String calleNumero;

    private String colonia;

    private String localidad;

    private String muinicipio;

    private String estado;

    private String cp;

    //(cascade = CascadeType.MERGE)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nuevo_ingreso_id", referencedColumnName = "idNuevoIngreso")
    private NuevoIngreso nuevoIngreso;

}
