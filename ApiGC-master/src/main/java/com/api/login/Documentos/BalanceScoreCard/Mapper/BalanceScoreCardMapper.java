package com.api.login.Documentos.BalanceScoreCard.Mapper;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceScoreCardDTO;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceSCPrespectiva;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceScoreCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BalanceScoreCardMapper {

    @Autowired
    private BalanceSCPrespectivaMapper balanceSCPrespectivaMapper;

    public BalanceScoreCardDTO toDTO(BalanceScoreCard entity) {
        BalanceScoreCardDTO dto = new BalanceScoreCardDTO();
        dto.setIdBalanceScoreCard(entity.getIdBalanceScoreCard());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        // Mapear la lista de perspectivas relacionadas
        if (entity.getBalanceSCPrespectivas() != null) {
            dto.setBalanceSCPrespectivas(entity.getBalanceSCPrespectivas().stream()
                    .map(balanceSCPrespectivaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public BalanceScoreCard toEntity(BalanceScoreCardDTO dto) {
        BalanceScoreCard entity = new BalanceScoreCard();
        entity.setIdBalanceScoreCard(dto.getIdBalanceScoreCard());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        // Mapear la lista de perspectivas relacionadas
        if (dto.getBalanceSCPrespectivas() != null) {
            List<BalanceSCPrespectiva> perspectivas = dto.getBalanceSCPrespectivas().stream()
                    .map(perspectivaDTO -> {
                        BalanceSCPrespectiva perspectiva = balanceSCPrespectivaMapper.toEntity(perspectivaDTO, entity);
                        perspectiva.setBalanceScoreCard(entity);  // Asignar la relación
                        return perspectiva;
                    })
                    .collect(Collectors.toList());
            entity.setBalanceSCPrespectivas(perspectivas);
        }

        return entity;
    }
}

