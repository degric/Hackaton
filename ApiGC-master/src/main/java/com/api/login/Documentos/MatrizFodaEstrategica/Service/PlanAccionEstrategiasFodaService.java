package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.PlanAccionEstrategiasFoda;

import java.util.List;

public interface PlanAccionEstrategiasFodaService {

    List<PlanAccionEstrategiasFoda> findAll();

    List<PlanAccionEstrategiasFoda> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    PlanAccionEstrategiasFoda findById(Long id);

    PlanAccionEstrategiasFoda save(PlanAccionEstrategiasFoda planAccionEstrategiasFoda);

    PlanAccionEstrategiasFoda update(Long id, PlanAccionEstrategiasFoda planAccionEstrategiasFoda);

    PlanAccionEstrategiasFoda buscador(String tipo, String estrategias);

    void deleteById(Long id);
}
