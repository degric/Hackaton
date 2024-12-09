package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.PlanAccionEstrategiasFoda;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.PlanAccionEstrategiasFodaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.PlanAccionEstrategiasFodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlanAccionEstrategiasFodaServiceImpl implements PlanAccionEstrategiasFodaService {

    @Autowired
    private PlanAccionEstrategiasFodaRepository planAccionRepository;

    @Override
    public List<PlanAccionEstrategiasFoda> findAll() {
        return planAccionRepository.findAll();
    }

    @Override
    public List<PlanAccionEstrategiasFoda> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return planAccionRepository.findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(idMatrizFodaEstrategica);
    }

    @Override
    public PlanAccionEstrategiasFoda findById(Long id) {
        Optional<PlanAccionEstrategiasFoda> optional = planAccionRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public PlanAccionEstrategiasFoda save(PlanAccionEstrategiasFoda planAccionEstrategiasFoda) {
        return planAccionRepository.save(planAccionEstrategiasFoda);
    }

    @Override
    public PlanAccionEstrategiasFoda update(Long id, PlanAccionEstrategiasFoda planAccionEstrategiasFoda) {
        Optional<PlanAccionEstrategiasFoda> optional = planAccionRepository.findById(id);
        if (optional.isPresent()) {
            planAccionEstrategiasFoda.setIdPlanAccionEstrategiasFoda(id);
            return planAccionRepository.save(planAccionEstrategiasFoda);
        } else {
            return null;
        }
    }

    @Override
    public PlanAccionEstrategiasFoda buscador(String tipo, String estrategias) {
        return planAccionRepository.findByTipoAndEstrategias(tipo, estrategias);
    }

    @Override
    public void deleteById(Long id) {
        planAccionRepository.deleteById(id);
    }
}

