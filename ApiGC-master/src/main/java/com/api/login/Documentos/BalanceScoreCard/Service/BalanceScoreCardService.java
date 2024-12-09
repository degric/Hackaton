package com.api.login.Documentos.BalanceScoreCard.Service;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceScoreCardDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface BalanceScoreCardService {

    List<BalanceScoreCardDTO> findAll();

    BalanceScoreCardDTO findById(Long id);

    BalanceScoreCardDTO save(BalanceScoreCardDTO balanceScoreCardDTO);

    BalanceScoreCardDTO update(Long id, BalanceScoreCardDTO balanceScoreCardDTO);

    void deleteById(Long id);

    byte[] generarBSCPdf(Long id) throws DocumentException;
}

