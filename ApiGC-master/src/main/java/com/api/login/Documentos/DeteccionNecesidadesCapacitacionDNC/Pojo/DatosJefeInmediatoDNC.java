package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "DatosJefeInmediatoDNC")
public class DatosJefeInmediatoDNC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDatosJefeInmediatoDNC;

    private String nombre;
    private String puesto;
    private String area;
    private Date fecha;

    // Relación uno a uno con DetecionNeCaDNC
    @OneToOne
    @JoinColumn(name = "idDetecionNeCaDNC", referencedColumnName = "idDetecionNeCaDNC")
    private DetecionNeCaDNC detecionNeCaDNC;
}

