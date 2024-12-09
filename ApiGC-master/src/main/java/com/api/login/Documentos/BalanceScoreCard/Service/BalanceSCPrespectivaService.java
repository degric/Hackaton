package com.api.login.Documentos.BalanceScoreCard.Service;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceSCPrespectivaDTO;

import java.util.List;

public interface BalanceSCPrespectivaService {

    List<BalanceSCPrespectivaDTO> findAll();

    BalanceSCPrespectivaDTO findById(Long id);

    List<BalanceSCPrespectivaDTO> findByBalanceScoreCard(Long idBalanceScoreCard);

    BalanceSCPrespectivaDTO save(BalanceSCPrespectivaDTO balanceSCPrespectivaDTO);

    BalanceSCPrespectivaDTO update(Long id, BalanceSCPrespectivaDTO balanceSCPrespectivaDTO);

    void deleteById(Long id);
}
