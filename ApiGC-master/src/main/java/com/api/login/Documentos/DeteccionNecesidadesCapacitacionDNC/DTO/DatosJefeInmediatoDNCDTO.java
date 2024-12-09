package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class DatosJefeInmediatoDNCDTO {

    private Long idDatosJefeInmediatoDNC;
    private String nombre;
    private String puesto;
    private String area;
    private Date fecha;
    private Long idDetecionNeCaDNC; // Relación con DetecionNeCaDNC
}
