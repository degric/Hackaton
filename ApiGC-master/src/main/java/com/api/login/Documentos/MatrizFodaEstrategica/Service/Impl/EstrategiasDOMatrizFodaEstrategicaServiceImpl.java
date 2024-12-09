package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDOMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.EstrategiasDOMatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.EstrategiasDOMatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstrategiasDOMatrizFodaEstrategicaServiceImpl implements EstrategiasDOMatrizFodaEstrategicaService {

    @Autowired
    private EstrategiasDOMatrizFodaEstrategicaRepository estrategiasDORepository;

    @Override
    public List<EstrategiasDOMatrizFodaEstrategica> findAll() {
        return estrategiasDORepository.findAll();
    }

    @Override
    public List<EstrategiasDOMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return estrategiasDORepository.findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(idMatrizFodaEstrategica);
    }

    @Override
    public EstrategiasDOMatrizFodaEstrategica findById(Long id) {
        Optional<EstrategiasDOMatrizFodaEstrategica> optional = estrategiasDORepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public EstrategiasDOMatrizFodaEstrategica save(EstrategiasDOMatrizFodaEstrategica estrategiasDOMatrizFodaEstrategica) {
        return estrategiasDORepository.save(estrategiasDOMatrizFodaEstrategica);
    }

    @Override
    public EstrategiasDOMatrizFodaEstrategica update(Long id, EstrategiasDOMatrizFodaEstrategica estrategiasDOMatrizFodaEstrategica) {
        Optional<EstrategiasDOMatrizFodaEstrategica> optional = estrategiasDORepository.findById(id);
        if (optional.isPresent()) {
            estrategiasDOMatrizFodaEstrategica.setIdEstrategiasDOMatrizFodaEstrategica(id);
            return estrategiasDORepository.save(estrategiasDOMatrizFodaEstrategica);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        estrategiasDORepository.deleteById(id);
    }
}

