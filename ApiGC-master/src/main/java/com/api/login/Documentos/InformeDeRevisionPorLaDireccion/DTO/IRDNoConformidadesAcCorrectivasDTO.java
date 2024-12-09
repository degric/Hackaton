package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class IRDNoConformidadesAcCorrectivasDTO {

    private Long idIRDNoConformidadesAcCorrectivas;
    private String tipo;
    private String reportadas;
    private String enSeguimiento;
    private String implementadas;
    private String cerradas;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}

