package com.api.login.Documentos.ControlDocumentosExternos.DTO;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class ControlDocumentosExternosDTO {

    private Long idControlDocumentosExternos;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;
    private String area;
    private String seccion;
    private LocalDate fecha;
    private List<TablaControlDocumentosExternosDTO> tablasControlDocumentosExternos;
    private List<ModificacionesControlDocExDTO> modificacionesControlDocEx;
}

