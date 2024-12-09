package com.api.login.Documentos.Planauditoria.Mapper;

import com.api.login.Documentos.Planauditoria.DTO.PlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanAuditoriaMapper {

    @Autowired
    private DatosPlanAuditoriaMapper datosPlanAuditoriaMapper;

    @Autowired
    private EquipoAuditorPlanAuditoriaMapper equipoAuditorMapper;

    @Autowired
    private ObservacionesPlanAuditoriasMapper observacionesMapper;

    @Autowired
    private CuerpoPlanAuditoriaMapper cuerpoMapper;

    public PlanAuditoriaDTO toDTO(PlanAuditoria entity) {
        PlanAuditoriaDTO dto = new PlanAuditoriaDTO();
        dto.setIdPlanAuditoria(entity.getIdPlanAuditoria());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        // Mapear la lista de datos del plan de auditoría relacionados
        if (entity.getDatosPlanAuditoriaList() != null) {
            dto.setDatosPlanAuditoriaList(entity.getDatosPlanAuditoriaList().stream()
                    .map(datosPlanAuditoriaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de equipos auditores relacionados
        if (entity.getEquipoAuditorList() != null) {
            dto.setEquipoAuditorList(entity.getEquipoAuditorList().stream()
                    .map(equipoAuditorMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear Observaciones
        if (entity.getObservacionesList() != null) {
            dto.setObservacionesList(entity.getObservacionesList().stream()
                    .map(observacionesMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        if (entity.getCuerpoPlanAuditoriaList() != null) {
            dto.setCuerpoPlanAuditoriaList(entity.getCuerpoPlanAuditoriaList().stream()
                    .map(cuerpoMapper::toDTO)
                    .collect(Collectors.toList()));
        }



        return dto;
    }

    public PlanAuditoria toEntity(PlanAuditoriaDTO dto) {
        PlanAuditoria entity = new PlanAuditoria();
        entity.setIdPlanAuditoria(dto.getIdPlanAuditoria());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        // Mapear la lista de equipos auditores relacionados
        if (dto.getEquipoAuditorList() != null) {
            List<EquipoAuditorPlanAuditoria> equipoList = dto.getEquipoAuditorList().stream()
                    .map(equipoDTO -> {
                        EquipoAuditorPlanAuditoria equipo = equipoAuditorMapper.toEntity(equipoDTO, entity);
                        equipo.setPlanAuditoria(entity); // Asignar la relación
                        return equipo;
                    })
                    .collect(Collectors.toList());
            entity.setEquipoAuditorList(equipoList);
        }

        // Mapear la lista de datos del plan de auditoría relacionados
        if (dto.getDatosPlanAuditoriaList() != null) {
            List<DatosPlanAuditoria> datosList = dto.getDatosPlanAuditoriaList().stream()
                    .map(datosDTO -> {
                        DatosPlanAuditoria datos = datosPlanAuditoriaMapper.toEntity(datosDTO, entity);
                        datos.setPlanAuditoria(entity); // Asignar la relación
                        return datos;
                    })
                    .collect(Collectors.toList());
            entity.setDatosPlanAuditoriaList(datosList);
        }

        //Mapear Observaciones de plan auditorias
        if (dto.getObservacionesList() != null) {
            List<ObservacionesPlanAuditorias> observacionesList = dto.getObservacionesList().stream()
                    .map(observacionDTO -> {
                        ObservacionesPlanAuditorias observacion = observacionesMapper.toEntity(observacionDTO, entity);
                        observacion.setPlanAuditoria(entity); // Asignar la relación
                        return observacion;
                    })
                    .collect(Collectors.toList());
            entity.setObservacionesList(observacionesList);
        }

        if (dto.getCuerpoPlanAuditoriaList() != null) {
            List<CuerpoPlanAuditoria> cuerpoList = dto.getCuerpoPlanAuditoriaList().stream()
                    .map(cuerpoDTO -> {
                        CuerpoPlanAuditoria cuerpo = cuerpoMapper.toEntity(cuerpoDTO, entity);
                        cuerpo.setPlanAuditoria(entity);
                        return cuerpo;
                    })
                    .collect(Collectors.toList());
            entity.setCuerpoPlanAuditoriaList(cuerpoList);
        }


        return entity;
    }
}
