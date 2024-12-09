package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

@Data
public class IRDDesemProveExternosDTO {

    private Long idIRDDesemProveExternos;
    private String proveedor;
    private String tiempoEntrega;
    private String precio;
    private String calidad;
    private String calificacion;
    private Long idInformeRevisionDireccion;  // Relación con InformeRevisionDireccion
}

