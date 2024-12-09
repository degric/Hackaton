package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "DatosGeneralesDNC")
public class DatosGeneralesDNC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDatosGeneralesDNC;

    private String nombre;
    private String puesto;
    private String antiguedadEmpresa;
    private String antiguedadPuesto;
    private String escolaridad;

    // Relación uno a uno con DetecionNeCaDNC
    @OneToOne
    @JoinColumn(name = "idDetecionNeCaDNC", referencedColumnName = "idDetecionNeCaDNC")
    private DetecionNeCaDNC detecionNeCaDNC;
}
