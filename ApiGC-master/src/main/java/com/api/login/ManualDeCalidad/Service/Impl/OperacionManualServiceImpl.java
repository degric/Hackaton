package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.OperacionManual;
import com.api.login.ManualDeCalidad.Dao.OperacionManualDao;
import com.api.login.ManualDeCalidad.Service.OperacionManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperacionManualServiceImpl implements OperacionManualService {

    @Autowired
    private OperacionManualDao operacionManualRepository;

    @Override
    public List<OperacionManual> findAll() {
        return operacionManualRepository.findAll();
    }

    @Override
    public OperacionManual findById(Long id) {
        Optional<OperacionManual> optionalOperacionManual = operacionManualRepository.findById(id);
        return optionalOperacionManual.orElse(null);
    }

    @Override
    public OperacionManual save(OperacionManual operacionManual) {
        return operacionManualRepository.save(operacionManual);
    }

    @Override
    public OperacionManual update(Long id, OperacionManual operacionManual) {
        Optional<OperacionManual> optionalOperacionManual = operacionManualRepository.findById(id);
        if (optionalOperacionManual.isPresent()) {
            operacionManual.setIdOperacionManual(id);
            return operacionManualRepository.save(operacionManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        operacionManualRepository.deleteById(id);
    }

    @Override
    public List<OperacionManual> findByManualCalidadId(Long idManualCalidad) {
        return operacionManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

