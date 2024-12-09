package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.ApoyoManual;
import com.api.login.ManualDeCalidad.Dao.ApoyoManualDao;
import com.api.login.ManualDeCalidad.Service.ApoyoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoyoManualServiceImpl implements ApoyoManualService {

    @Autowired
    private ApoyoManualDao apoyoManualRepository;

    @Override
    public List<ApoyoManual> findAll() {
        return apoyoManualRepository.findAll();
    }

    @Override
    public ApoyoManual findById(Long id) {
        Optional<ApoyoManual> optionalApoyoManual = apoyoManualRepository.findById(id);
        return optionalApoyoManual.orElse(null);
    }

    @Override
    public ApoyoManual save(ApoyoManual apoyoManual) {
        return apoyoManualRepository.save(apoyoManual);
    }

    @Override
    public ApoyoManual update(Long id, ApoyoManual apoyoManual) {
        Optional<ApoyoManual> optionalApoyoManual = apoyoManualRepository.findById(id);
        if (optionalApoyoManual.isPresent()) {
            apoyoManual.setIdApoyoManual(id);
            return apoyoManualRepository.save(apoyoManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        apoyoManualRepository.deleteById(id);
    }

    @Override
    public List<ApoyoManual> findByManualCalidadId(Long idManualCalidad) {
        return apoyoManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}
