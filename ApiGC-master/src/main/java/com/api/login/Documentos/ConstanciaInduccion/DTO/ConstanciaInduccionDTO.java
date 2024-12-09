package com.api.login.Documentos.ConstanciaInduccion.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ConstanciaInduccionDTO {

    private Long idConstanciaInduccion;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private LocalDate fecha;

    private List<InformacionConsInduDTO> informacionConsIndus;
    private ColaboradorConsInducDTO colaboradorConsInduc;
    private List<ColaboradoresConsInduDTO> colaboradoresConsIndus;
}
