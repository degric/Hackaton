package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.MatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.DTO.MatrizFodaEstrategicaDTOSinListas;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatrizFodaEstrategicaMapper {

    @Autowired
    private FortalezasMatrizFodaEstrategicaMapper fortalezasMapper;

    @Autowired
    private DebilidadesMatrizFodaEstrategicaMapper debilidadesMapper;

    @Autowired
    private OportunidadesMatrizFodaEstrategicaMapper oportunidadesMapper;

    @Autowired
    private EstrategiasFOMatrizFodaEstrategicaMapper estrategiasFOMapper;

    @Autowired
    private EstrategiasDOMatrizFodaEstrategicaMapper estrategiasDOMapper;

    @Autowired
    private AmenazasMatrizFodaEstrategicaMapper amenazasMapper;

    @Autowired
    private EstrategiasFAMatrizFodaEstrategicaMapper estrategiasFAMapper;

    @Autowired
    private EstrategiasDAMatrizFodaEstrategicaMapper estrategiasDAMapper;

    @Autowired
    private PlanAccionEstrategiasFodaMapper planAccionMapper;

    public MatrizFodaEstrategicaDTO toDTO(MatrizFodaEstrategica entity) {
        MatrizFodaEstrategicaDTO dto = new MatrizFodaEstrategicaDTO();
        dto.setIdMatrizFodaEstrategica(entity.getIdMatrizFodaEstrategica());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setFechaRegistro(entity.getFechaRegistro());

        if (entity.getFortalezas() != null) {
            dto.setFortalezas(entity.getFortalezas().stream()
                    .map(fortalezasMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setFortalezas(Collections.emptyList());
        }

        if (entity.getDebilidades() != null) {
            dto.setDebilidades(entity.getDebilidades().stream()
                    .map(debilidadesMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setDebilidades(Collections.emptyList());
        }

        if (entity.getOportunidades() != null) {
            dto.setOportunidades(entity.getOportunidades().stream()
                    .map(oportunidadesMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setOportunidades(Collections.emptyList());
        }

        if (entity.getEstrategiasFO() != null) {
            dto.setEstrategiasFO(entity.getEstrategiasFO().stream()
                    .map(estrategiasFOMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setEstrategiasFO(Collections.emptyList());
        }

        if (entity.getEstrategiasDO() != null) {
            dto.setEstrategiasDO(entity.getEstrategiasDO().stream()
                    .map(estrategiasDOMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setEstrategiasDO(Collections.emptyList());
        }

        if (entity.getAmenazas() != null) {
            dto.setAmenazas(entity.getAmenazas().stream()
                    .map(amenazasMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setAmenazas(Collections.emptyList());
        }

        if (entity.getEstrategiasFA() != null) {
            dto.setEstrategiasFA(entity.getEstrategiasFA().stream()
                    .map(estrategiasFAMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setEstrategiasFA(Collections.emptyList());
        }

        if (entity.getEstrategiasDA() != null) {
            dto.setEstrategiasDA(entity.getEstrategiasDA().stream()
                    .map(estrategiasDAMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setEstrategiasDA(Collections.emptyList());
        }

        if (entity.getPlanesAccion() != null) {
            dto.setPlanesAccion(entity.getPlanesAccion().stream()
                    .map(planAccionMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setPlanesAccion(Collections.emptyList());
        }


        return dto;
    }

    public MatrizFodaEstrategicaDTOSinListas toDTOSinListas(MatrizFodaEstrategica entity) {
        MatrizFodaEstrategicaDTOSinListas dto = new MatrizFodaEstrategicaDTOSinListas();
        dto.setIdMatrizFodaEstrategica(entity.getIdMatrizFodaEstrategica());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setFechaRegistro(entity.getFechaRegistro());
        return dto;
    }

    public MatrizFodaEstrategica toEntity(MatrizFodaEstrategicaDTO dto) {
        MatrizFodaEstrategica entity = new MatrizFodaEstrategica();
        entity.setIdMatrizFodaEstrategica(dto.getIdMatrizFodaEstrategica());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setFechaRegistro(dto.getFechaRegistro());

        if (dto.getFortalezas() != null) {
            List<FortalezasMatrizFodaEstrategica> fortalezasList = dto.getFortalezas().stream()
                    .map(fortalezaDTO -> fortalezasMapper.toEntity(fortalezaDTO, entity))
                    .collect(Collectors.toList());
            entity.setFortalezas(fortalezasList);
        }

        if (dto.getDebilidades() != null) {
            List<DebilidadesMatrizFodaEstrategica> debilidadesList = dto.getDebilidades().stream()
                    .map(debilidadDTO -> debilidadesMapper.toEntity(debilidadDTO, entity))
                    .collect(Collectors.toList());
            entity.setDebilidades(debilidadesList);
        }

        if (dto.getOportunidades() != null) {
            List<OportunidadesMatrizFodaEstrategica> oportunidadesList = dto.getOportunidades().stream()
                    .map(oportunidadDTO -> oportunidadesMapper.toEntity(oportunidadDTO, entity))
                    .collect(Collectors.toList());
            entity.setOportunidades(oportunidadesList);
        }

        if (dto.getEstrategiasFO() != null) {
            List<EstrategiasFOMatrizFodaEstrategica> estrategiasFOList = dto.getEstrategiasFO().stream()
                    .map(estrategiaFODTO -> estrategiasFOMapper.toEntity(estrategiaFODTO, entity))
                    .collect(Collectors.toList());
            entity.setEstrategiasFO(estrategiasFOList);
        }

        if (dto.getEstrategiasDO() != null) {
            List<EstrategiasDOMatrizFodaEstrategica> estrategiasDOList = dto.getEstrategiasDO().stream()
                    .map(estrategiaDODTO -> estrategiasDOMapper.toEntity(estrategiaDODTO, entity))
                    .collect(Collectors.toList());
            entity.setEstrategiasDO(estrategiasDOList);
        }

        if (dto.getAmenazas() != null) {
            List<AmenazasMatrizFodaEstrategica> amenazasMatrizList = dto.getAmenazas().stream()
                    .map(amenazasMatrizFodaEstrategicaDTO -> amenazasMapper.toEntity(amenazasMatrizFodaEstrategicaDTO, entity))
                    .collect(Collectors.toList());
            entity.setAmenazas(amenazasMatrizList);
        }

        if (dto.getEstrategiasFA() != null) {
            List<EstrategiasFAMatrizFodaEstrategica> estrategiasFAList = dto.getEstrategiasFA().stream()
                    .map(estrategiaFADTO -> estrategiasFAMapper.toEntity(estrategiaFADTO, entity))
                    .collect(Collectors.toList());
            entity.setEstrategiasFA(estrategiasFAList);
        }

        if (dto.getEstrategiasDA() != null) {
            List<EstrategiasDAMatrizFodaEstrategica> estrategiasDAList = dto.getEstrategiasDA().stream()
                    .map(estrategiaDADTO -> estrategiasDAMapper.toEntity(estrategiaDADTO, entity))
                    .collect(Collectors.toList());
            entity.setEstrategiasDA(estrategiasDAList);
        }

        if (dto.getPlanesAccion() != null) {
            List<PlanAccionEstrategiasFoda> planesAccionList = dto.getPlanesAccion().stream()
                    .map(planAccionDTO -> planAccionMapper.toEntity(planAccionDTO, entity))
                    .collect(Collectors.toList());
            entity.setPlanesAccion(planesAccionList);
        }

        return entity;
    }
}



