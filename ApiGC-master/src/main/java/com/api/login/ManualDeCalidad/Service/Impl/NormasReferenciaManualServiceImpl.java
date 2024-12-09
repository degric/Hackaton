package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.NormasReferenciaManual;
import com.api.login.ManualDeCalidad.Dao.NormasReferenciaManualDao;
import com.api.login.ManualDeCalidad.Service.NormasReferenciaManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NormasReferenciaManualServiceImpl implements NormasReferenciaManualService {

    @Autowired
    private NormasReferenciaManualDao normasReferenciaManualRepository;

    @Override
    public List<NormasReferenciaManual> findAll() {
        return normasReferenciaManualRepository.findAll();
    }

    @Override
    public NormasReferenciaManual findById(Long id) {
        Optional<NormasReferenciaManual> optionalNormasReferenciaManual = normasReferenciaManualRepository.findById(id);
        return optionalNormasReferenciaManual.orElse(null);
    }

    @Override
    public NormasReferenciaManual save(NormasReferenciaManual normasReferenciaManual) {
        return normasReferenciaManualRepository.save(normasReferenciaManual);
    }

    @Override
    public NormasReferenciaManual update(Long id, NormasReferenciaManual normasReferenciaManual) {
        Optional<NormasReferenciaManual> optionalNormasReferenciaManual = normasReferenciaManualRepository.findById(id);
        if (optionalNormasReferenciaManual.isPresent()) {
            normasReferenciaManual.setIdNormasReferenciaManual(id);
            return normasReferenciaManualRepository.save(normasReferenciaManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        normasReferenciaManualRepository.deleteById(id);
    }

    @Override
    public List<NormasReferenciaManual> findByManualCalidadId(Long idManualCalidad) {
        return normasReferenciaManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

