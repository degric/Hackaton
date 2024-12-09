package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.LiderazgoManual;
import com.api.login.ManualDeCalidad.Dao.LiderazgoManualDao;
import com.api.login.ManualDeCalidad.Service.LiderazgoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiderazgoManualServiceImpl implements LiderazgoManualService {

    @Autowired
    private LiderazgoManualDao liderazgoManualRepository;

    @Override
    public List<LiderazgoManual> findAll() {
        return liderazgoManualRepository.findAll();
    }

    @Override
    public LiderazgoManual findById(Long id) {
        Optional<LiderazgoManual> optionalLiderazgoManual = liderazgoManualRepository.findById(id);
        return optionalLiderazgoManual.orElse(null);
    }

    @Override
    public LiderazgoManual save(LiderazgoManual liderazgoManual) {
        return liderazgoManualRepository.save(liderazgoManual);
    }

    @Override
    public LiderazgoManual update(Long id, LiderazgoManual liderazgoManual) {
        Optional<LiderazgoManual> optionalLiderazgoManual = liderazgoManualRepository.findById(id);
        if (optionalLiderazgoManual.isPresent()) {
            liderazgoManual.setIdLiderazgoManual(id);
            return liderazgoManualRepository.save(liderazgoManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        liderazgoManualRepository.deleteById(id);
    }

    @Override
    public List<LiderazgoManual> findByManualCalidadId(Long idManualCalidad) {
        return liderazgoManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}
