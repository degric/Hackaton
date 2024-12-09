package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.PlanificacionManual;
import com.api.login.ManualDeCalidad.Dao.PlanificacionManualDao;
import com.api.login.ManualDeCalidad.Service.PlanificacionManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanificacionManualServiceImpl implements PlanificacionManualService {

    @Autowired
    private PlanificacionManualDao planificacionManualRepository;

    @Override
    public List<PlanificacionManual> findAll() {
        return planificacionManualRepository.findAll();
    }

    @Override
    public PlanificacionManual findById(Long id) {
        Optional<PlanificacionManual> optionalPlanificacionManual = planificacionManualRepository.findById(id);
        return optionalPlanificacionManual.orElse(null);
    }

    @Override
    public PlanificacionManual save(PlanificacionManual planificacionManual) {
        return planificacionManualRepository.save(planificacionManual);
    }

    @Override
    public PlanificacionManual update(Long id, PlanificacionManual planificacionManual) {
        Optional<PlanificacionManual> optionalPlanificacionManual = planificacionManualRepository.findById(id);
        if (optionalPlanificacionManual.isPresent()) {
            planificacionManual.setIdPlanificacionManual(id);
            return planificacionManualRepository.save(planificacionManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        planificacionManualRepository.deleteById(id);
    }

    @Override
    public List<PlanificacionManual> findByManualCalidadId(Long idManualCalidad) {
        return planificacionManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

