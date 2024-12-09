package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
public class DetecionNeCaDNCDTO {

    private Long idDetecionNeCaDNC;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    private DatosGeneralesDNCDTO datosGeneralesDNC;
    private DatosJefeInmediatoDNCDTO datosJefeInmediatoDNC;
    private List<Pregunta1DNCDTO> preguntas1DNC;
    private List<Preguntas2DNCDTO> preguntas2DNC;

}
