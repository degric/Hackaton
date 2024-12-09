package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO;

import lombok.Data;

@Data
public class DatosGeneralesDNCDTO {

    private Long idDatosGeneralesDNC;
    private String nombre;
    private String puesto;
    private String antiguedadEmpresa;
    private String antiguedadPuesto;
    private String escolaridad;
    private Long idDetecionNeCaDNC;  // Relación con DetecionNeCaDNC
}
