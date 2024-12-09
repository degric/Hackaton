package com.api.login.Documentos.NuevoIngreso.DTO;

import lombok.Data;

@Data
public class DatPersonalNuevoIngresoDTO {
    private Integer idDatPersonalNuevoIngreso;

    private String rfc;

    private String tipoSangre;

    private String noTelefono;

    private String noPerTelefono;

    private String noSeguroSocial;

    private String liConducir;

    private String noLicencia;

    private String email;

    private String nivelEstudios;

    private String pasatiempos;

    private Integer idNuevoIngreso;
}
