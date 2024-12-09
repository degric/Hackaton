package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFOMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.PlanAccionEstrategiasFoda;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.EstrategiasFOMatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.PlanAccionEstrategiasFodaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.EstrategiasFOMatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.PlanAccionEstrategiasFodaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstrategiasFOMatrizFodaEstrategicaServiceImpl implements EstrategiasFOMatrizFodaEstrategicaService {

    @Autowired
    private EstrategiasFOMatrizFodaEstrategicaRepository estrategiasFORepository;

    @Autowired
    private PlanAccionEstrategiasFodaService planAccionEstrategiasFodaService;

    @Override
    public List<EstrategiasFOMatrizFodaEstrategica> findAll() {
        return estrategiasFORepository.findAll();
    }

    @Override
    public List<EstrategiasFOMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return estrategiasFORepository.findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(idMatrizFodaEstrategica);
    }

    @Override
    public EstrategiasFOMatrizFodaEstrategica findById(Long id) {
        Optional<EstrategiasFOMatrizFodaEstrategica> optional = estrategiasFORepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public EstrategiasFOMatrizFodaEstrategica save(EstrategiasFOMatrizFodaEstrategica estrategiasFOMatrizFodaEstrategica) {
        EstrategiasFOMatrizFodaEstrategica estrategiasFOMatrizFoda = estrategiasFORepository.save(estrategiasFOMatrizFodaEstrategica);

            PlanAccionEstrategiasFoda entity = new PlanAccionEstrategiasFoda();
            entity.setTipo("FO");
            entity.setEstrategias(estrategiasFOMatrizFodaEstrategica.getContenido());
            entity.setObjetivo(null);
            entity.setFolio(null);
            entity.setResponsable(null);
            entity.setFechaMeta(null);
            entity.setMatrizFodaEstrategica(estrategiasFOMatrizFodaEstrategica.getMatrizFodaEstrategica());
            planAccionEstrategiasFodaService.save(entity);

        return estrategiasFOMatrizFoda;
    }

    @Override
    public EstrategiasFOMatrizFodaEstrategica update(Long id, EstrategiasFOMatrizFodaEstrategica estrategiasFOMatrizFodaEstrategica) {
        // Buscar la entidad existente por ID
        Optional<EstrategiasFOMatrizFodaEstrategica> optional = estrategiasFORepository.findById(id);
        if (optional.isPresent()) {
            // Establecer el ID en la entidad que vamos a actualizar
            estrategiasFOMatrizFodaEstrategica.setIdEstrategiasFOMatrizFodaEstrategica(id);

            // Guardar la entidad actualizada
            EstrategiasFOMatrizFodaEstrategica estrategiasFOMatrizFoda = estrategiasFORepository.save(estrategiasFOMatrizFodaEstrategica);

            // Buscar la entidad relacionada PlanAccionEstrategiasFoda usando el contenido anterior
            PlanAccionEstrategiasFoda entity = planAccionEstrategiasFodaService.buscador("FO", estrategiasFORepository.findById(id).get().getContenido());

            System.out.println(entity.getIdPlanAccionEstrategiasFoda());

            if (entity != null) {
                // Actualizar la entidad existente con el nuevo contenido
                entity.setEstrategias(estrategiasFOMatrizFodaEstrategica.getContenido());
                entity.setMatrizFodaEstrategica(estrategiasFOMatrizFodaEstrategica.getMatrizFodaEstrategica());
                // Actualizar otros campos si es necesario
                planAccionEstrategiasFodaService.save(entity);
            }
            // Si la entidad no existe, no hacemos nada

            return estrategiasFOMatrizFoda;
        } else {
            // Manejar el caso donde la entidad no existe
            return null;
        }
    }


    @Override
    public void deleteById(Long id) {
        Optional<EstrategiasFOMatrizFodaEstrategica> entity = estrategiasFORepository.findById(id);

        if (planAccionEstrategiasFodaService.buscador("FO",entity.get().getContenido()) != null){
            planAccionEstrategiasFodaService.deleteById(planAccionEstrategiasFodaService.buscador("FO",entity.get().getContenido()).getIdPlanAccionEstrategiasFoda());
        }
        estrategiasFORepository.deleteById(id);
    }
}

