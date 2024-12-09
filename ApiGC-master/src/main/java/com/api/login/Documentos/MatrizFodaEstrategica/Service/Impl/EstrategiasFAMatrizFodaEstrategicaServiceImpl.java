package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFAMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.EstrategiasFAMatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.EstrategiasFAMatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstrategiasFAMatrizFodaEstrategicaServiceImpl implements EstrategiasFAMatrizFodaEstrategicaService {

    @Autowired
    private EstrategiasFAMatrizFodaEstrategicaRepository estrategiasFARepository;

    @Override
    public List<EstrategiasFAMatrizFodaEstrategica> findAll() {
        return estrategiasFARepository.findAll();
    }

    @Override
    public List<EstrategiasFAMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return estrategiasFARepository.findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(idMatrizFodaEstrategica);
    }

    @Override
    public EstrategiasFAMatrizFodaEstrategica findById(Long id) {
        Optional<EstrategiasFAMatrizFodaEstrategica> optional = estrategiasFARepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public EstrategiasFAMatrizFodaEstrategica save(EstrategiasFAMatrizFodaEstrategica estrategiasFAMatrizFodaEstrategica) {
        return estrategiasFARepository.save(estrategiasFAMatrizFodaEstrategica);
    }

    @Override
    public EstrategiasFAMatrizFodaEstrategica update(Long id, EstrategiasFAMatrizFodaEstrategica estrategiasFAMatrizFodaEstrategica) {
        Optional<EstrategiasFAMatrizFodaEstrategica> optional = estrategiasFARepository.findById(id);
        if (optional.isPresent()) {
            estrategiasFAMatrizFodaEstrategica.setIdEstrategiasFAMatrizFodaEstrategica(id);
            return estrategiasFARepository.save(estrategiasFAMatrizFodaEstrategica);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        estrategiasFARepository.deleteById(id);
    }
}
