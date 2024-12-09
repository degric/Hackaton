package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.InformeRevisionDireccionDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InformeRevisionDireccionMapper {


    @Autowired
    private InformeRevisionDireccionEntradaMapper informeRevisionDireccionEntradaMapper;

    @Autowired
    private EntradasRevisiondireccion_AMapper entradasRevisiondireccion_AMapper;

    @Autowired
    private EntradasRevisiondireccion_BMapper entradasRevisiondireccion_BMapper;

    @Autowired
    private EntradasRevisiondireccion_CMapper entradasRevisiondireccion_CMapper;

    @Autowired
    private IRDObjetivosCalidadMapper irdObjetivosCalidadMapper;

    @Autowired
    private IRDProcesosConformidadServiciosMapper irdProcesosConformidadServiciosMapper;

    @Autowired
    private IRDNoConformidadesAcCorrectivasMapper irdNoConformidadesAcCorrectivasMapper;
    @Autowired
    private IRDResultadosSeguimientoMedicionMapper irdResultadosSeguimientoMedicionMapper;
    @Autowired
    private IRDResultadosAuditoriaMapper irdResultadosAuditoriaMapper;
    @Autowired
    private IRDDesemProveExternosMapper irdDesemProveExternosMapper;

    @Autowired
    private IRDAdecuacionRecursosMapper irdAdecuacionRecursosMapper;




    public InformeRevisionDireccionDTO toDTO(InformeRevisionDireccion entity) {
        InformeRevisionDireccionDTO dto = new InformeRevisionDireccionDTO();
        dto.setIdInformeRevisionDireccion(entity.getIdInformeRevisionDireccion());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        // Mapear la lista de entradas relacionadas
        if (entity.getEntradas() != null) {
            dto.setEntradas(entity.getEntradas().stream()
                    .map(informeRevisionDireccionEntradaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de entradas relacionadas con EntradasRevisiondireccion_A
        if (entity.getEntradasRevisiondireccion_A() != null) {
            dto.setEntradasRevisiondireccion_A(entity.getEntradasRevisiondireccion_A().stream()
                    .map(entradasRevisiondireccion_AMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de entradas relacionadas con EntradasRevisiondireccion_B
        if (entity.getEntradasRevisiondireccion_B() != null) {
            dto.setEntradasRevisiondireccion_B(entity.getEntradasRevisiondireccion_B().stream()
                    .map(entradasRevisiondireccion_BMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de entradas relacionadas con EntradasRevisiondireccion_C
        if (entity.getEntradasRevisiondireccion_C() != null) {
            dto.setEntradasRevisiondireccion_C(entity.getEntradasRevisiondireccion_C().stream()
                    .map(entradasRevisiondireccion_CMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de objetivos relacionados con IRDObjetivosCalidad
        if (entity.getIrdObjetivosCalidad() != null) {
            dto.setIrdObjetivosCalidad(entity.getIrdObjetivosCalidad().stream()
                    .map(irdObjetivosCalidadMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de procesos de conformidad relacionados
        if (entity.getIrdProcesosConformidadServicios() != null) {
            dto.setIrdProcesosConformidadServicios(entity.getIrdProcesosConformidadServicios().stream()
                    .map(irdProcesosConformidadServiciosMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de no conformidades relacionadas
        if (entity.getIrdNoConformidadesAcCorrectivas() != null) {
            dto.setIrdNoConformidadesAcCorrectivas(entity.getIrdNoConformidadesAcCorrectivas().stream()
                    .map(irdNoConformidadesAcCorrectivasMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        // Mapear la lista de resultados de seguimiento y medición relacionados
        if (entity.getIrdResultadosSeguimientoMedicion() != null) {
            dto.setIrdResultadosSeguimientoMedicion(entity.getIrdResultadosSeguimientoMedicion().stream()
                    .map(irdResultadosSeguimientoMedicionMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de resultados de auditoría relacionados
        if (entity.getIrdResultadosAuditoria() != null) {
            dto.setIrdResultadosAuditoria(entity.getIrdResultadosAuditoria().stream()
                    .map(irdResultadosAuditoriaMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        // Mapear la lista de proveedores externos relacionados
        if (entity.getIrdDesemProveExternos() != null) {
            dto.setIrdDesemProveExternos(entity.getIrdDesemProveExternos().stream()
                    .map(irdDesemProveExternosMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        // Mapear la lista de recursos de adecuación relacionados
        if (entity.getIrdAdecuacionRecursos() != null) {
            dto.setIrdAdecuacionRecursos(entity.getIrdAdecuacionRecursos().stream()
                    .map(irdAdecuacionRecursosMapper::toDTO)
                    .collect(Collectors.toList()));
        }


        return dto;
    }

    public InformeRevisionDireccion toEntity(InformeRevisionDireccionDTO dto) {
        InformeRevisionDireccion entity = new InformeRevisionDireccion();
        entity.setIdInformeRevisionDireccion(dto.getIdInformeRevisionDireccion());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        // Mapear la lista de entradas relacionadas
        if (dto.getEntradas() != null) {
            List<InformeRevisionDireccionEntrada> entradas = dto.getEntradas().stream()
                    .map(entradaDTO -> {
                        InformeRevisionDireccionEntrada entrada = informeRevisionDireccionEntradaMapper.toEntity(entradaDTO, entity);
                        entrada.setInformeRevisionDireccion(entity);  // Asignamos la relación
                        return entrada;
                    })
                    .collect(Collectors.toList());
            entity.setEntradas(entradas);
        }

        // Mapear la lista de entradas relacionadas con EntradasRevisiondireccion_A
        if (dto.getEntradasRevisiondireccion_A() != null) {
            List<EntradasRevisiondireccion_A> entradas = dto.getEntradasRevisiondireccion_A().stream()
                    .map(entradaDTO -> {
                        EntradasRevisiondireccion_A entrada = entradasRevisiondireccion_AMapper.toEntity(entradaDTO, entity);
                        entrada.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return entrada;
                    })
                    .collect(Collectors.toList());
            entity.setEntradasRevisiondireccion_A(entradas);
        }

        // Mapear la lista de entradas relacionadas con EntradasRevisiondireccion_B
        if (dto.getEntradasRevisiondireccion_B() != null) {
            List<EntradasRevisiondireccion_B> entradas = dto.getEntradasRevisiondireccion_B().stream()
                    .map(entradaDTO -> {
                        EntradasRevisiondireccion_B entrada = entradasRevisiondireccion_BMapper.toEntity(entradaDTO, entity);
                        entrada.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return entrada;
                    })
                    .collect(Collectors.toList());
            entity.setEntradasRevisiondireccion_B(entradas);
        }

        // Mapear la lista de entradas relacionadas con EntradasRevisiondireccion_C
        if (dto.getEntradasRevisiondireccion_C() != null) {
            List<EntradasRevisiondireccion_C> entradas = dto.getEntradasRevisiondireccion_C().stream()
                    .map(entradaDTO -> {
                        EntradasRevisiondireccion_C entrada = entradasRevisiondireccion_CMapper.toEntity(entradaDTO, entity);
                        entrada.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return entrada;
                    })
                    .collect(Collectors.toList());
            entity.setEntradasRevisiondireccion_C(entradas);
        }

        // Mapear la lista de objetivos relacionados con IRDObjetivosCalidad
        if (dto.getIrdObjetivosCalidad() != null) {
            List<IRDObjetivosCalidad> objetivos = dto.getIrdObjetivosCalidad().stream()
                    .map(objetivoDTO -> {
                        IRDObjetivosCalidad objetivo = irdObjetivosCalidadMapper.toEntity(objetivoDTO, entity);
                        objetivo.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return objetivo;
                    })
                    .collect(Collectors.toList());
            entity.setIrdObjetivosCalidad(objetivos);
        }

        // Mapear la lista de procesos de conformidad relacionados
        if (dto.getIrdProcesosConformidadServicios() != null) {
            List<IRDProcesosConformidadServicios> procesos = dto.getIrdProcesosConformidadServicios().stream()
                    .map(procesoDTO -> {
                        IRDProcesosConformidadServicios proceso = irdProcesosConformidadServiciosMapper.toEntity(procesoDTO, entity);
                        proceso.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return proceso;
                    })
                    .collect(Collectors.toList());
            entity.setIrdProcesosConformidadServicios(procesos);
        }

        // Mapear la lista de no conformidades relacionadas
        if (dto.getIrdNoConformidadesAcCorrectivas() != null) {
            List<IRDNoConformidadesAcCorrectivas> noConformidades = dto.getIrdNoConformidadesAcCorrectivas().stream()
                    .map(noConformidadDTO -> {
                        IRDNoConformidadesAcCorrectivas noConformidad = irdNoConformidadesAcCorrectivasMapper.toEntity(noConformidadDTO, entity);
                        noConformidad.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return noConformidad;
                    })
                    .collect(Collectors.toList());
            entity.setIrdNoConformidadesAcCorrectivas(noConformidades);
        }
        // Mapear la lista de resultados de seguimiento y medición relacionados
        if (dto.getIrdResultadosSeguimientoMedicion() != null) {
            List<IRDResultadosSeguimientoMedicion> resultados = dto.getIrdResultadosSeguimientoMedicion().stream()
                    .map(resultadoDTO -> {
                        IRDResultadosSeguimientoMedicion resultado = irdResultadosSeguimientoMedicionMapper.toEntity(resultadoDTO, entity);
                        resultado.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return resultado;
                    })
                    .collect(Collectors.toList());
            entity.setIrdResultadosSeguimientoMedicion(resultados);
        }
        // Mapear la lista de resultados de auditoría relacionados
        if (dto.getIrdResultadosAuditoria() != null) {
            List<IRDResultadosAuditoria> resultados = dto.getIrdResultadosAuditoria().stream()
                    .map(resultadoDTO -> {
                        IRDResultadosAuditoria resultado = irdResultadosAuditoriaMapper.toEntity(resultadoDTO, entity);
                        resultado.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return resultado;
                    })
                    .collect(Collectors.toList());
            entity.setIrdResultadosAuditoria(resultados);
        }
        // Mapear la lista de proveedores externos relacionados
        if (dto.getIrdDesemProveExternos() != null) {
            List<IRDDesemProveExternos> proveedores = dto.getIrdDesemProveExternos().stream()
                    .map(proveedorDTO -> {
                        IRDDesemProveExternos proveedor = irdDesemProveExternosMapper.toEntity(proveedorDTO, entity);
                        proveedor.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return proveedor;
                    })
                    .collect(Collectors.toList());
            entity.setIrdDesemProveExternos(proveedores);
        }
        // Mapear la lista de recursos de adecuación relacionados
        if (dto.getIrdAdecuacionRecursos() != null) {
            List<IRDAdecuacionRecursos> recursos = dto.getIrdAdecuacionRecursos().stream()
                    .map(recursoDTO -> {
                        IRDAdecuacionRecursos recurso = irdAdecuacionRecursosMapper.toEntity(recursoDTO, entity);
                        recurso.setInformeRevisionDireccion(entity);  // Asignar la relación
                        return recurso;
                    })
                    .collect(Collectors.toList());
            entity.setIrdAdecuacionRecursos(recursos);
        }

        return entity;
    }
}
