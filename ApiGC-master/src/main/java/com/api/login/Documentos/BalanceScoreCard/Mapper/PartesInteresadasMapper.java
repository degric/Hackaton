package com.api.login.Documentos.BalanceScoreCard.Mapper;

import com.api.login.Documentos.BalanceScoreCard.DTO.PartesInteresadasDTO;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceSCPrespectiva;
import com.api.login.Documentos.BalanceScoreCard.Pojo.PartesInteresadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PartesInteresadasMapper {



    public PartesInteresadasDTO toDTO(PartesInteresadas entity) {
        PartesInteresadasDTO dto = new PartesInteresadasDTO();
        dto.setIdPartesInteresadas(entity.getIdPartesInteresadas());
        dto.setNombre(entity.getNombre());
        dto.setInteres(entity.getInteres());
        dto.setInfluencia(entity.getInfluencia());
        dto.setIdBalanceSCPrespectiva(entity.getBalanceSCPrespectiva().getIdBalanceSCPrespectiva());



        return dto;
    }

    public PartesInteresadas toEntity(PartesInteresadasDTO dto, BalanceSCPrespectiva balanceSCPrespectiva) {
        PartesInteresadas entity = new PartesInteresadas();
        entity.setIdPartesInteresadas(dto.getIdPartesInteresadas());
        entity.setNombre(dto.getNombre());
        entity.setInteres(dto.getInteres());
        entity.setInfluencia(dto.getInfluencia());
        entity.setBalanceSCPrespectiva(balanceSCPrespectiva);
        return entity;
    }
}
