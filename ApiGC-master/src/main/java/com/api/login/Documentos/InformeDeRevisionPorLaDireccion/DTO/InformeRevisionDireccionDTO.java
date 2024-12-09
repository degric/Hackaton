package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InformeRevisionDireccionDTO {

    private Long idInformeRevisionDireccion;
    private String coDocumento;
    private String noRevision;
    private LocalDate fechaEmicion;
    private LocalDate fechaRevision;

    // Lista de entradas relacionadas
    private List<InformeRevisionDireccionEntradaDTO> entradas;
    // Lista de entradas relacionadas con EntradasRevisiondireccion_A
    private List<EntradasRevisiondireccion_ADTO> entradasRevisiondireccion_A;
    // Lista de entradas relacionadas con EntradasRevisiondireccion_B
    private List<EntradasRevisiondireccion_BDTO> entradasRevisiondireccion_B;
    // Lista de entradas relacionadas con EntradasRevisiondireccion_C
    private List<EntradasRevisiondireccion_CDTO> entradasRevisiondireccion_C;
    // Lista de objetivos de calidad relacionados
    private List<IRDObjetivosCalidadDTO> irdObjetivosCalidad;
    // Lista de procesos de conformidad y servicios relacionados
    private List<IRDProcesosConformidadServiciosDTO> irdProcesosConformidadServicios;
    // Lista de no conformidades relacionadas
    private List<IRDNoConformidadesAcCorrectivasDTO> irdNoConformidadesAcCorrectivas;
    // Lista de resultados de seguimiento y medición relacionados
    private List<IRDResultadosSeguimientoMedicionDTO> irdResultadosSeguimientoMedicion;
    // Lista de resultados de auditoría relacionados
    private List<IRDResultadosAuditoriaDTO> irdResultadosAuditoria;
    // Lista de proveedores externos relacionados
    private List<IRDDesemProveExternosDTO> irdDesemProveExternos;
    // Lista de recursos de adecuación relacionados
    private List<IRDAdecuacionRecursosDTO> irdAdecuacionRecursos;

}

