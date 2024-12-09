package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.Dao.ContextoOrganizacionManualDao;
import com.api.login.ManualDeCalidad.pojo.ContextoOrganizacionManual;
import com.api.login.ManualDeCalidad.Service.ContextoOrganizacionManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContextoOrganizacionManualServiceImpl implements ContextoOrganizacionManualService {

    @Autowired
    private ContextoOrganizacionManualDao contextoOrganizacionManualRepository;

    @Override
    public List<ContextoOrganizacionManual> findAll() {
        return contextoOrganizacionManualRepository.findAll();
    }

    @Override
    public ContextoOrganizacionManual findById(Long id) {
        Optional<ContextoOrganizacionManual> optionalContextoOrganizacionManual = contextoOrganizacionManualRepository.findById(id);
        return optionalContextoOrganizacionManual.orElse(null);
    }

    @Override
    public ContextoOrganizacionManual save(ContextoOrganizacionManual contextoOrganizacionManual) {
        return contextoOrganizacionManualRepository.save(contextoOrganizacionManual);
    }

    @Override
    public ContextoOrganizacionManual update(Long id, ContextoOrganizacionManual contextoOrganizacionManual) {
        Optional<ContextoOrganizacionManual> optionalContextoOrganizacionManual = contextoOrganizacionManualRepository.findById(id);
        if (optionalContextoOrganizacionManual.isPresent()) {
            contextoOrganizacionManual.setIdContextoOrganizacionManual(id);
            return contextoOrganizacionManualRepository.save(contextoOrganizacionManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        contextoOrganizacionManualRepository.deleteById(id);
    }

    @Override
    public List<ContextoOrganizacionManual> findByManualCalidadId(Long idManualCalidad) {
        return contextoOrganizacionManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

