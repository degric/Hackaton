package com.api.login.Documentos.BalanceScoreCard.Service;

import com.api.login.Documentos.BalanceScoreCard.DTO.MetricasBSCDTO;
import com.api.login.Documentos.BalanceScoreCard.DTO.ObjetivoDTO;

import java.util.List;

public interface MetricasBSCService {

    List<MetricasBSCDTO> findAll();

    MetricasBSCDTO findById(Long id);

    List<MetricasBSCDTO> findByBalanceSCPrespectiva(Long idBalanceSCPrespectiva);

    MetricasBSCDTO save(MetricasBSCDTO metricasBSCDTO);

    MetricasBSCDTO update(Long id, MetricasBSCDTO metricasBSCDTO);

    void deleteById(Long id);

    List<ObjetivoDTO> findDistinctObjetivos();

    List<MetricasBSCDTO> findByObjetivo(String objetivo);
}
