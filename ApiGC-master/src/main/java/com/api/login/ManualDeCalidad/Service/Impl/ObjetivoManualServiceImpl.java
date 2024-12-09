package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.ObjetivoManual;
import com.api.login.ManualDeCalidad.Dao.ObjetivoManualDao;
import com.api.login.ManualDeCalidad.Service.ObjetivoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoManualServiceImpl implements ObjetivoManualService {

    @Autowired
    private ObjetivoManualDao objetivoManualRepository;

    @Override
    public List<ObjetivoManual> findAll() {
        return objetivoManualRepository.findAll();
    }

    @Override
    public ObjetivoManual findById(Long id) {
        Optional<ObjetivoManual> optionalObjetivoManual = objetivoManualRepository.findById(id);
        return optionalObjetivoManual.orElse(null);
    }

    @Override
    public ObjetivoManual save(ObjetivoManual objetivoManual) {
        return objetivoManualRepository.save(objetivoManual);
    }

    @Override
    public ObjetivoManual update(Long id, ObjetivoManual objetivoManual) {
        Optional<ObjetivoManual> optionalObjetivoManual = objetivoManualRepository.findById(id);
        if (optionalObjetivoManual.isPresent()) {
            objetivoManual.setIdObjetivoManual(id);
            return objetivoManualRepository.save(objetivoManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        objetivoManualRepository.deleteById(id);
    }

    @Override
    public List<ObjetivoManual> findByManualCalidadId(Long idManualCalidad) {
        return objetivoManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

