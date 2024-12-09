package com.api.login.Documentos.ReporteDeAuditoria.Mapper;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.ReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReporteAuditoriaMapper {

    @Autowired
    private InfoReporteAuditoriaMapper infoMapper;

    @Autowired
    private CierreReporteAuditoria1Mapper cierreMapper;

    @Autowired
    private CierreReporteAuditoria2Mapper cierre2Mapper;

    @Autowired
    private HallazgoReporteAuditoriaMapper hallazgoMapper;


    public ReporteAuditoriaDTO toDTO(ReporteAuditoria entity) {
        ReporteAuditoriaDTO dto = new ReporteAuditoriaDTO();
        dto.setIdReporteAuditoria(entity.getIdReporteAuditoria());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        if (entity.getInfoReporteAuditoria() != null) {
            dto.setInfoReporteAuditoria(infoMapper.toDTO(entity.getInfoReporteAuditoria()));
        }

        if (entity.getCierreReporteAuditoria1List() != null) {
            dto.setCierreReporteAuditoria1List(entity.getCierreReporteAuditoria1List().stream()
                    .map(cierreMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        if (entity.getCierreReporteAuditoria2List() != null) {
            dto.setCierreReporteAuditoria2List(entity.getCierreReporteAuditoria2List().stream()
                    .map(cierre2Mapper::toDTO)
                    .collect(Collectors.toList()));
        }

        if (entity.getHallazgoReporteAuditoriaList() != null) {
            dto.setHallazgoReporteAuditoriaList(entity.getHallazgoReporteAuditoriaList().stream()
                    .map(hallazgoMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public ReporteAuditoria toEntity(ReporteAuditoriaDTO dto) {
        ReporteAuditoria entity = new ReporteAuditoria();
        entity.setIdReporteAuditoria(dto.getIdReporteAuditoria());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        if (dto.getInfoReporteAuditoria() != null) {
            InfoReporteAuditoria info = infoMapper.toEntity(dto.getInfoReporteAuditoria(), entity);
            entity.setInfoReporteAuditoria(info);
        }

        if (dto.getCierreReporteAuditoria1List() != null) {
            List<CierreReporteAuditoria1> cierres = dto.getCierreReporteAuditoria1List().stream()
                    .map(cierreDTO -> {
                        CierreReporteAuditoria1 cierre = cierreMapper.toEntity(cierreDTO, entity);
                        cierre.setReporteAuditoria(entity);
                        return cierre;
                    })
                    .collect(Collectors.toList());
            entity.setCierreReporteAuditoria1List(cierres);
        }

        if (dto.getCierreReporteAuditoria2List() != null) {
            List<CierreReporteAuditoria2> cierres2 = dto.getCierreReporteAuditoria2List().stream()
                    .map(cierre2DTO -> {
                        CierreReporteAuditoria2 cierre2 = cierre2Mapper.toEntity(cierre2DTO, entity);
                        cierre2.setReporteAuditoria(entity);
                        return cierre2;
                    })
                    .collect(Collectors.toList());
            entity.setCierreReporteAuditoria2List(cierres2);
        }

        if (dto.getHallazgoReporteAuditoriaList() != null) {
            List<HallazgoReporteAuditoria> hallazgos = dto.getHallazgoReporteAuditoriaList().stream()
                    .map(hallazgoDTO -> {
                        HallazgoReporteAuditoria hallazgo = hallazgoMapper.toEntity(hallazgoDTO, entity);
                        hallazgo.setReporteAuditoria(entity);
                        return hallazgo;
                    })
                    .collect(Collectors.toList());
            entity.setHallazgoReporteAuditoriaList(hallazgos);
        }


        return entity;
    }
}

