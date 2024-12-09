package com.api.login.Documentos.BalanceScoreCard.Mapper;

import com.api.login.Documentos.BalanceScoreCard.DTO.MetricasBSCDTO;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceSCPrespectiva;
import com.api.login.Documentos.BalanceScoreCard.Pojo.MetricasBSC;
import org.springframework.stereotype.Component;

@Component
public class MetricasBSCMapper {

    public MetricasBSCDTO toDTO(MetricasBSC entity) {
        MetricasBSCDTO dto = new MetricasBSCDTO();
        dto.setIdMetricasBSC(entity.getIdMetricasBSC());
        dto.setObjetivo(entity.getObjetivo());
        dto.setMeta(entity.getMeta());
        dto.setFrecuencia(entity.getFrecuencia());
        dto.setResponsable(entity.getResponsable());
        dto.setEstadoActual(entity.getEstadoActual());
        dto.setIdBalanceSCPrespectiva(entity.getBalanceSCPrespectiva().getIdBalanceSCPrespectiva());
        return dto;
    }

    public MetricasBSC toEntity(MetricasBSCDTO dto, BalanceSCPrespectiva balanceSCPrespectiva) {
        MetricasBSC entity = new MetricasBSC();
        entity.setIdMetricasBSC(dto.getIdMetricasBSC());
        entity.setObjetivo(dto.getObjetivo());
        entity.setMeta(dto.getMeta());
        entity.setFrecuencia(dto.getFrecuencia());
        entity.setResponsable(dto.getResponsable());
        entity.setEstadoActual(dto.getEstadoActual());
        entity.setBalanceSCPrespectiva(balanceSCPrespectiva);
        return entity;
    }
}
