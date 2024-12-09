package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.DebilidadesMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.DebilidadesMatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.DebilidadesMatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DebilidadesMatrizFodaEstrategicaServiceImpl implements DebilidadesMatrizFodaEstrategicaService {

    @Autowired
    private DebilidadesMatrizFodaEstrategicaRepository debilidadesRepository;

    @Override
    public List<DebilidadesMatrizFodaEstrategica> findAll() {
        return debilidadesRepository.findAll();
    }

    @Override
    public List<DebilidadesMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return debilidadesRepository.findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(idMatrizFodaEstrategica);
    }

    @Override
    public DebilidadesMatrizFodaEstrategica findById(Long id) {
        Optional<DebilidadesMatrizFodaEstrategica> optional = debilidadesRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public DebilidadesMatrizFodaEstrategica save(DebilidadesMatrizFodaEstrategica debilidadesMatrizFodaEstrategica) {
        return debilidadesRepository.save(debilidadesMatrizFodaEstrategica);
    }

    @Override
    public DebilidadesMatrizFodaEstrategica update(Long id, DebilidadesMatrizFodaEstrategica debilidadesMatrizFodaEstrategica) {
        Optional<DebilidadesMatrizFodaEstrategica> optional = debilidadesRepository.findById(id);
        if (optional.isPresent()) {
            debilidadesMatrizFodaEstrategica.setIdDebilidadesMatrizFodaEstrategica(id);
            return debilidadesRepository.save(debilidadesMatrizFodaEstrategica);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        debilidadesRepository.deleteById(id);
    }
}
