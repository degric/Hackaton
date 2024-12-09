package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDAMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.EstrategiasDAMatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.EstrategiasDAMatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstrategiasDAMatrizFodaEstrategicaServiceImpl implements EstrategiasDAMatrizFodaEstrategicaService {

    @Autowired
    private EstrategiasDAMatrizFodaEstrategicaRepository estrategiasDARepository;

    @Override
    public List<EstrategiasDAMatrizFodaEstrategica> findAll() {
        return estrategiasDARepository.findAll();
    }

    @Override
    public List<EstrategiasDAMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return estrategiasDARepository.findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(idMatrizFodaEstrategica);
    }

    @Override
    public EstrategiasDAMatrizFodaEstrategica findById(Long id) {
        Optional<EstrategiasDAMatrizFodaEstrategica> optional = estrategiasDARepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public EstrategiasDAMatrizFodaEstrategica save(EstrategiasDAMatrizFodaEstrategica estrategiasDAMatrizFodaEstrategica) {

        return estrategiasDARepository.save(estrategiasDAMatrizFodaEstrategica);
    }

    @Override
    public EstrategiasDAMatrizFodaEstrategica update(Long id, EstrategiasDAMatrizFodaEstrategica estrategiasDAMatrizFodaEstrategica) {
        Optional<EstrategiasDAMatrizFodaEstrategica> optional = estrategiasDARepository.findById(id);
        if (optional.isPresent()) {
            estrategiasDAMatrizFodaEstrategica.setIdEstrategiasDAMatrizFodaEstrategica(id);
            return estrategiasDARepository.save(estrategiasDAMatrizFodaEstrategica);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        estrategiasDARepository.deleteById(id);
    }
}

