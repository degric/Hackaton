package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDAMatrizFodaEstrategica;

import java.util.List;

public interface EstrategiasDAMatrizFodaEstrategicaService {

    List<EstrategiasDAMatrizFodaEstrategica> findAll();

    List<EstrategiasDAMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    EstrategiasDAMatrizFodaEstrategica findById(Long id);

    EstrategiasDAMatrizFodaEstrategica save(EstrategiasDAMatrizFodaEstrategica estrategiasDAMatrizFodaEstrategica);

    EstrategiasDAMatrizFodaEstrategica update(Long id, EstrategiasDAMatrizFodaEstrategica estrategiasDAMatrizFodaEstrategica);

    void deleteById(Long id);
}

