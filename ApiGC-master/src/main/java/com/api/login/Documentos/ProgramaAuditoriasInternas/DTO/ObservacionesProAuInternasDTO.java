package com.api.login.Documentos.ProgramaAuditoriasInternas.DTO;

import lombok.Data;

@Data
public class ObservacionesProAuInternasDTO {
    private Integer idObservacionesProAuInternas;

    private String observaciones;

    private String elaboro;

    private String autorizo;

    private Integer idProgramaAuditoriasInternas;
}
