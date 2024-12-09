package com.api.login.Documentos.BalanceScoreCard.Service;

import com.api.login.Documentos.BalanceScoreCard.DTO.PartesInteresadasDTO;

import java.util.List;

public interface PartesInteresadasService {

    List<PartesInteresadasDTO> findAll();

    PartesInteresadasDTO findById(Long id);

    List<PartesInteresadasDTO> findByBalanceSCPrespectiva(Long idBalanceSCPrespectiva);

    PartesInteresadasDTO save(PartesInteresadasDTO partesInteresadasDTO);

    PartesInteresadasDTO update(Long id, PartesInteresadasDTO partesInteresadasDTO);

    void deleteById(Long id);
}
