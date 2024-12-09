package com.api.login.Documentos.BalanceScoreCard.Service.Impl;

import com.api.login.Documentos.BalanceScoreCard.DTO.MetricasBSCDTO;
import com.api.login.Documentos.BalanceScoreCard.DTO.ObjetivoDTO;
import com.api.login.Documentos.BalanceScoreCard.Mapper.MetricasBSCMapper;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceSCPrespectiva;
import com.api.login.Documentos.BalanceScoreCard.Pojo.MetricasBSC;
import com.api.login.Documentos.BalanceScoreCard.Repository.BalanceSCPrespectivaRepository;
import com.api.login.Documentos.BalanceScoreCard.Repository.MetricasBSCRepository;
import com.api.login.Documentos.BalanceScoreCard.Service.MetricasBSCService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetricasBSCServiceImpl implements MetricasBSCService {

    @Autowired
    private MetricasBSCRepository metricasBSCRepository;

    @Autowired
    private BalanceSCPrespectivaRepository balanceSCPrespectivaRepository;

    @Autowired
    private MetricasBSCMapper metricasBSCMapper;

    @Override
    public List<MetricasBSCDTO> findAll() {
        return metricasBSCRepository.findAll().stream()
                .map(metricasBSCMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MetricasBSCDTO findById(Long id) {
        MetricasBSC metricas = metricasBSCRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Métrica BSC no encontrada"));
        return metricasBSCMapper.toDTO(metricas);
    }

    @Override
    public List<MetricasBSCDTO> findByBalanceSCPrespectiva(Long idBalanceSCPrespectiva) {
        List<MetricasBSC> metricasList = metricasBSCRepository
                .findByBalanceSCPrespectiva_IdBalanceSCPrespectiva(idBalanceSCPrespectiva);
        return metricasList.stream()
                .map(metricasBSCMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MetricasBSCDTO save(MetricasBSCDTO metricasBSCDTO) {
        BalanceSCPrespectiva balanceSCPrespectiva = balanceSCPrespectivaRepository
                .findById(metricasBSCDTO.getIdBalanceSCPrespectiva())
                .orElseThrow(() -> new EntityNotFoundException("Balance SCP respectiva no encontrado"));

        MetricasBSC metricas = metricasBSCMapper.toEntity(metricasBSCDTO, balanceSCPrespectiva);
        MetricasBSC savedMetricas = metricasBSCRepository.save(metricas);
        return metricasBSCMapper.toDTO(savedMetricas);
    }

    @Override
    public MetricasBSCDTO update(Long id, MetricasBSCDTO metricasBSCDTO) {
        MetricasBSC existingMetricas = metricasBSCRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Métrica BSC no encontrada"));

        existingMetricas.setObjetivo(metricasBSCDTO.getObjetivo());
        existingMetricas.setMeta(metricasBSCDTO.getMeta());
        existingMetricas.setFrecuencia(metricasBSCDTO.getFrecuencia());
        existingMetricas.setResponsable(metricasBSCDTO.getResponsable());
        existingMetricas.setEstadoActual(metricasBSCDTO.getEstadoActual());

        MetricasBSC updatedMetricas = metricasBSCRepository.save(existingMetricas);
        return metricasBSCMapper.toDTO(updatedMetricas);
    }

    @Override
    public void deleteById(Long id) {
        metricasBSCRepository.deleteById(id);
    }

    @Override
    public List<ObjetivoDTO> findDistinctObjetivos() {
        List<String> objetivosUnicos = metricasBSCRepository.findDistinctObjetivos();
        return objetivosUnicos.stream()
                .map(ObjetivoDTO::new)  // Convertir cada objetivo en un ObjetivoDTO
                .collect(Collectors.toList());
    }
    @Override
    public List<MetricasBSCDTO> findByObjetivo(String objetivo) {
        return metricasBSCRepository.findByObjetivoContainingIgnoreCase(objetivo).stream()
                .map(metricasBSCMapper::toDTO)
                .collect(Collectors.toList());
    }

}

