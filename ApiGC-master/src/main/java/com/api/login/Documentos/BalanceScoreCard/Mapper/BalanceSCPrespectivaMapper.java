package com.api.login.Documentos.BalanceScoreCard.Mapper;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceSCPrespectivaDTO;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceSCPrespectiva;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceScoreCard;
import com.api.login.Documentos.BalanceScoreCard.Pojo.MetricasBSC;
import com.api.login.Documentos.BalanceScoreCard.Pojo.PartesInteresadas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BalanceSCPrespectivaMapper {

    @Autowired
    private PartesInteresadasMapper partesInteresadasMapper;

    @Autowired
    private MetricasBSCMapper metricasBSCMapper;

    public BalanceSCPrespectivaDTO toDTO(BalanceSCPrespectiva entity) {
        BalanceSCPrespectivaDTO dto = new BalanceSCPrespectivaDTO();
        dto.setIdBalanceSCPrespectiva(entity.getIdBalanceSCPrespectiva());
        dto.setContenido(entity.getContenido());
        dto.setIdBalanceScoreCard(entity.getBalanceScoreCard().getIdBalanceScoreCard());

        // Mapear la lista de partes interesadas relacionadas
        if (entity.getPartesInteresadas() != null) {
            dto.setPartesInteresadas(entity.getPartesInteresadas().stream()
                    .map(partesInteresadasMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de métricas relacionadas
        if (entity.getMetricasBSCList() != null) {
            dto.setMetricasBSCList(entity.getMetricasBSCList().stream()
                    .map(metricasBSCMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public BalanceSCPrespectiva toEntity(BalanceSCPrespectivaDTO dto, BalanceScoreCard balanceScoreCard) {
        BalanceSCPrespectiva entity = new BalanceSCPrespectiva();
        entity.setIdBalanceSCPrespectiva(dto.getIdBalanceSCPrespectiva());
        entity.setContenido(dto.getContenido());
        entity.setBalanceScoreCard(balanceScoreCard);


        // Mapear la lista de partes interesadas relacionadas
        if (dto.getPartesInteresadas() != null) {
            List<PartesInteresadas> partesList = dto.getPartesInteresadas().stream()
                    .map(parteDTO -> {
                        PartesInteresadas parte = partesInteresadasMapper.toEntity(parteDTO, entity);
                        parte.setBalanceSCPrespectiva(entity);  // Asignar la relación
                        return parte;
                    })
                    .collect(Collectors.toList());
            entity.setPartesInteresadas(partesList);
        }

        // Mapear la lista de métricas relacionadas
        if (dto.getMetricasBSCList() != null) {
            List<MetricasBSC> metricasList = dto.getMetricasBSCList().stream()
                    .map(metricaDTO -> {
                        MetricasBSC metrica = metricasBSCMapper.toEntity(metricaDTO, entity);
                        metrica.setBalanceSCPrespectiva(entity);  // Asignar la relación
                        return metrica;
                    })
                    .collect(Collectors.toList());
            entity.setMetricasBSCList(metricasList);
        }

        return entity;
    }
}

