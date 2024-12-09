package com.api.login.Documentos.BalanceScoreCard.Service.Impl;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceSCPrespectivaDTO;
import com.api.login.Documentos.BalanceScoreCard.Mapper.BalanceSCPrespectivaMapper;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceSCPrespectiva;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceScoreCard;
import com.api.login.Documentos.BalanceScoreCard.Repository.BalanceSCPrespectivaRepository;
import com.api.login.Documentos.BalanceScoreCard.Repository.BalanceScoreCardRepository;
import com.api.login.Documentos.BalanceScoreCard.Service.BalanceSCPrespectivaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalanceSCPrespectivaServiceImpl implements BalanceSCPrespectivaService {

    @Autowired
    private BalanceSCPrespectivaRepository balanceSCPrespectivaRepository;

    @Autowired
    private BalanceScoreCardRepository balanceScoreCardRepository;

    @Autowired
    private BalanceSCPrespectivaMapper balanceSCPrespectivaMapper;

    @Override
    public List<BalanceSCPrespectivaDTO> findAll() {
        return balanceSCPrespectivaRepository.findAll().stream()
                .map(balanceSCPrespectivaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BalanceSCPrespectivaDTO findById(Long id) {
        BalanceSCPrespectiva balance = balanceSCPrespectivaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Elemento de BalanceSCPrespectiva no encontrado"));
        return balanceSCPrespectivaMapper.toDTO(balance);
    }

    @Override
    public List<BalanceSCPrespectivaDTO> findByBalanceScoreCard(Long idBalanceScoreCard) {
        List<BalanceSCPrespectiva> balances = balanceSCPrespectivaRepository
                .findByBalanceScoreCard_IdBalanceScoreCard(idBalanceScoreCard);
        return balances.stream()
                .map(balanceSCPrespectivaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BalanceSCPrespectivaDTO save(BalanceSCPrespectivaDTO balanceSCPrespectivaDTO) {
        BalanceScoreCard balanceScoreCard = balanceScoreCardRepository
                .findById(balanceSCPrespectivaDTO.getIdBalanceScoreCard())
                .orElseThrow(() -> new EntityNotFoundException("Balance Score Card no encontrado"));

        BalanceSCPrespectiva balance = balanceSCPrespectivaMapper.toEntity(balanceSCPrespectivaDTO, balanceScoreCard);
        BalanceSCPrespectiva savedBalance = balanceSCPrespectivaRepository.save(balance);
        return balanceSCPrespectivaMapper.toDTO(savedBalance);
    }

    @Override
    public BalanceSCPrespectivaDTO update(Long id, BalanceSCPrespectivaDTO balanceSCPrespectivaDTO) {
        BalanceSCPrespectiva existingBalance = balanceSCPrespectivaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Elemento de BalanceSCPrespectiva no encontrado"));

        existingBalance.setContenido(balanceSCPrespectivaDTO.getContenido());

        BalanceSCPrespectiva updatedBalance = balanceSCPrespectivaRepository.save(existingBalance);
        return balanceSCPrespectivaMapper.toDTO(updatedBalance);
    }

    @Override
    public void deleteById(Long id) {
        balanceSCPrespectivaRepository.deleteById(id);
    }
}
