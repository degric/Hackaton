package com.api.login.Documentos.ConstanciaInduccion.Mapper;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ConstanciaInduccionDTO;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ColaboradoresConsIndu;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.InformacionConsIndu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConstanciaInduccionMapper {

    @Autowired
    private InformacionConsInduMapper informacionMapper;

    @Autowired
    private ColaboradorConsInducMapper colaboradorMapper;

    @Autowired
    private ColaboradoresConsInduMapper colaboradoresMapper;

    public ConstanciaInduccionDTO toDTO(ConstanciaInduccion entity) {
        ConstanciaInduccionDTO dto = new ConstanciaInduccionDTO();
        dto.setIdConstanciaInduccion(entity.getIdConstanciaInduccion());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setFecha(entity.getFecha());

        if (entity.getInformacionConsIndus() != null) {
            dto.setInformacionConsIndus(entity.getInformacionConsIndus().stream()
                    .map(informacionMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        if (entity.getColaboradorConsInduc() != null) {
            dto.setColaboradorConsInduc(colaboradorMapper.toDTO(entity.getColaboradorConsInduc()));
        }
        if (entity.getColaboradoresConsIndus() != null) {
            dto.setColaboradoresConsIndus(entity.getColaboradoresConsIndus().stream()
                    .map(colaboradoresMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public ConstanciaInduccion toEntity(ConstanciaInduccionDTO dto) {
        ConstanciaInduccion entity = new ConstanciaInduccion();
        entity.setIdConstanciaInduccion(dto.getIdConstanciaInduccion());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setFecha(dto.getFecha());

        if (dto.getInformacionConsIndus() != null) {
            List<InformacionConsIndu> informaciones = dto.getInformacionConsIndus().stream()
                    .map(infoDTO -> informacionMapper.toEntity(infoDTO, entity))
                    .collect(Collectors.toList());
            entity.setInformacionConsIndus(informaciones);
        }

        if (dto.getColaboradorConsInduc() != null) {
            entity.setColaboradorConsInduc(colaboradorMapper.toEntity(dto.getColaboradorConsInduc(), entity));
        }
        if (dto.getColaboradoresConsIndus() != null) {
            List<ColaboradoresConsIndu> colaboradores = dto.getColaboradoresConsIndus().stream()
                    .map(colaboradoresDTO -> colaboradoresMapper.toEntity(colaboradoresDTO, entity))
                    .collect(Collectors.toList());
            entity.setColaboradoresConsIndus(colaboradores);
        }

        return entity;
    }
}

