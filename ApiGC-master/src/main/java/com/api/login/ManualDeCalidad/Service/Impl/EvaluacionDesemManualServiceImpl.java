package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.EvaluacionDesemManual;
import com.api.login.ManualDeCalidad.Dao.EvaluacionDesemManualDao;
import com.api.login.ManualDeCalidad.Service.EvaluacionDesemManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionDesemManualServiceImpl implements EvaluacionDesemManualService {

    @Autowired
    private EvaluacionDesemManualDao evaluacionDesemManualRepository;

    @Override
    public List<EvaluacionDesemManual> findAll() {
        return evaluacionDesemManualRepository.findAll();
    }

    @Override
    public EvaluacionDesemManual findById(Long id) {
        Optional<EvaluacionDesemManual> optionalEvaluacionDesemManual = evaluacionDesemManualRepository.findById(id);
        return optionalEvaluacionDesemManual.orElse(null);
    }

    @Override
    public EvaluacionDesemManual save(EvaluacionDesemManual evaluacionDesemManual) {
        return evaluacionDesemManualRepository.save(evaluacionDesemManual);
    }

    @Override
    public EvaluacionDesemManual update(Long id, EvaluacionDesemManual evaluacionDesemManual) {
        Optional<EvaluacionDesemManual> optionalEvaluacionDesemManual = evaluacionDesemManualRepository.findById(id);
        if (optionalEvaluacionDesemManual.isPresent()) {
            evaluacionDesemManual.setIdEvaluacionDesemManual(id);
            return evaluacionDesemManualRepository.save(evaluacionDesemManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        evaluacionDesemManualRepository.deleteById(id);
    }

    @Override
    public List<EvaluacionDesemManual> findByManualCalidadId(Long idManualCalidad) {
        return evaluacionDesemManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}
