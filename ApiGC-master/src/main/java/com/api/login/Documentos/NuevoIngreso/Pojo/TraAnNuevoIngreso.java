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
@Table(name = "TraAnNuevoIngreso")
public class TraAnNuevoIngreso {

    @Id
    @Column(name = "idTraAnNuevoIngreso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTraAnNuevoIngreso;

    private String fecha;

    private String lugar;

    private String funDesempenadas;

    @ManyToOne
    @JoinColumn(name = "nuevo_ingreso_id", referencedColumnName = "idNuevoIngreso")
    private NuevoIngreso nuevoIngreso;

}
