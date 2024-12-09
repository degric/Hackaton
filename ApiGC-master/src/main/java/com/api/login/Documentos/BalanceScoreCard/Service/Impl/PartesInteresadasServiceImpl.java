package com.api.login.Documentos.BalanceScoreCard.Service.Impl;

import com.api.login.Documentos.BalanceScoreCard.DTO.PartesInteresadasDTO;
import com.api.login.Documentos.BalanceScoreCard.Mapper.PartesInteresadasMapper;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceSCPrespectiva;
import com.api.login.Documentos.BalanceScoreCard.Pojo.PartesInteresadas;
import com.api.login.Documentos.BalanceScoreCard.Repository.BalanceSCPrespectivaRepository;
import com.api.login.Documentos.BalanceScoreCard.Repository.PartesInteresadasRepository;
import com.api.login.Documentos.BalanceScoreCard.Service.PartesInteresadasService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartesInteresadasServiceImpl implements PartesInteresadasService {

    @Autowired
    private PartesInteresadasRepository partesInteresadasRepository;

    @Autowired
    private BalanceSCPrespectivaRepository balanceSCPrespectivaRepository;

    @Autowired
    private PartesInteresadasMapper partesInteresadasMapper;

    @Override
    public List<PartesInteresadasDTO> findAll() {
        return partesInteresadasRepository.findAll().stream()
                .map(partesInteresadasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PartesInteresadasDTO findById(Long id) {
        PartesInteresadas parte = partesInteresadasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parte interesada no encontrada"));
        return partesInteresadasMapper.toDTO(parte);
    }

    @Override
    public List<PartesInteresadasDTO> findByBalanceSCPrespectiva(Long idBalanceSCPrespectiva) {
        List<PartesInteresadas> partes = partesInteresadasRepository
                .findByBalanceSCPrespectiva_IdBalanceSCPrespectiva(idBalanceSCPrespectiva);
        return partes.stream()
                .map(partesInteresadasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PartesInteresadasDTO save(PartesInteresadasDTO partesInteresadasDTO) {
        BalanceSCPrespectiva balanceSCPrespectiva = balanceSCPrespectivaRepository
                .findById(partesInteresadasDTO.getIdBalanceSCPrespectiva())
                .orElseThrow(() -> new EntityNotFoundException("Balance SCP respectiva no encontrado"));

        PartesInteresadas parte = partesInteresadasMapper.toEntity(partesInteresadasDTO, balanceSCPrespectiva);
        PartesInteresadas savedParte = partesInteresadasRepository.save(parte);
        return partesInteresadasMapper.toDTO(savedParte);
    }

    @Override
    public PartesInteresadasDTO update(Long id, PartesInteresadasDTO partesInteresadasDTO) {
        PartesInteresadas existingParte = partesInteresadasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parte interesada no encontrada"));

        existingParte.setNombre(partesInteresadasDTO.getNombre());
        existingParte.setInteres(partesInteresadasDTO.getInteres());
        existingParte.setInfluencia(partesInteresadasDTO.getInfluencia());

        PartesInteresadas updatedParte = partesInteresadasRepository.save(existingParte);
        return partesInteresadasMapper.toDTO(updatedParte);
    }

    @Override
    public void deleteById(Long id) {
        partesInteresadasRepository.deleteById(id);
    }
}
