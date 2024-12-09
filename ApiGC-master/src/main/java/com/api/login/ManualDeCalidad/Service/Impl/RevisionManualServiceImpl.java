package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.RevisionManual;
import com.api.login.ManualDeCalidad.Dao.RevisionManualDao;
import com.api.login.ManualDeCalidad.Service.RevisionManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevisionManualServiceImpl implements RevisionManualService {

    @Autowired
    private RevisionManualDao revisionManualRepository;

    @Override
    public List<RevisionManual> findAll() {
        return revisionManualRepository.findAll();
    }

    @Override
    public RevisionManual findById(Long id) {
        Optional<RevisionManual> optionalRevisionManual = revisionManualRepository.findById(id);
        return optionalRevisionManual.orElse(null);
    }

    @Override
    public RevisionManual save(RevisionManual revisionManual) {
        return revisionManualRepository.save(revisionManual);
    }

    @Override
    public RevisionManual update(Long id, RevisionManual revisionManual) {
        Optional<RevisionManual> optionalRevisionManual = revisionManualRepository.findById(id);
        if (optionalRevisionManual.isPresent()) {
            revisionManual.setIdRevisionManual(id);
            return revisionManualRepository.save(revisionManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        revisionManualRepository.deleteById(id);
    }

    @Override
    public List<RevisionManual> findByManualCalidadId(Long idManualCalidad) {
        return revisionManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

