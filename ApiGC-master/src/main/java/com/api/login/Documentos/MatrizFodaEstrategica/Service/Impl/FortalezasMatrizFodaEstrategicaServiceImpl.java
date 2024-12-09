package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.FortalezasMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.FortalezasMatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.FortalezasMatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FortalezasMatrizFodaEstrategicaServiceImpl implements FortalezasMatrizFodaEstrategicaService {

    @Autowired
    private FortalezasMatrizFodaEstrategicaRepository fortalezasRepository;

    @Override
    public List<FortalezasMatrizFodaEstrategica> findAll() {
        return fortalezasRepository.findAll();
    }

    @Override
    public List<FortalezasMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return fortalezasRepository.findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(idMatrizFodaEstrategica);
    }

    @Override
    public FortalezasMatrizFodaEstrategica findById(Long id) {
        Optional<FortalezasMatrizFodaEstrategica> optional = fortalezasRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public FortalezasMatrizFodaEstrategica save(FortalezasMatrizFodaEstrategica fortalezasMatrizFodaEstrategica) {
        return fortalezasRepository.save(fortalezasMatrizFodaEstrategica);
    }

    @Override
    public FortalezasMatrizFodaEstrategica update(Long id, FortalezasMatrizFodaEstrategica fortalezasMatrizFodaEstrategica) {
        Optional<FortalezasMatrizFodaEstrategica> optional = fortalezasRepository.findById(id);
        if (optional.isPresent()) {
            fortalezasMatrizFodaEstrategica.setIdFortalezasMatrizFodaEstrategica(id);
            return fortalezasRepository.save(fortalezasMatrizFodaEstrategica);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        fortalezasRepository.deleteById(id);
    }
}

