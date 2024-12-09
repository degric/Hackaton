package com.api.login.ManualDeCalidad.Service.Impl;
import com.api.login.ManualDeCalidad.Dao.IntroduccionManualDao;
import com.api.login.ManualDeCalidad.pojo.IntroduccionManual;
import com.api.login.ManualDeCalidad.Service.IntroduccionManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntroduccionManualServiceImpl implements IntroduccionManualService {

    @Autowired
    private IntroduccionManualDao introduccionManualRepository;

    @Override
    public List<IntroduccionManual> findAll() {
        return introduccionManualRepository.findAll();
    }

    @Override
    public IntroduccionManual findById(Long id) {
        Optional<IntroduccionManual> optionalIntroduccionManual = introduccionManualRepository.findById(id);

        return optionalIntroduccionManual.orElse(null);
    }

    @Override
    public IntroduccionManual save(IntroduccionManual introduccionManual) {
        return introduccionManualRepository.save(introduccionManual);
    }

    @Override
    public IntroduccionManual update(Long id, IntroduccionManual introduccionManual) {
        Optional<IntroduccionManual> optionalIntroduccionManual = introduccionManualRepository.findById(id);
        if (optionalIntroduccionManual.isPresent()) {
            introduccionManual.setIdIntroduccionManual(id);
            return introduccionManualRepository.save(introduccionManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        introduccionManualRepository.deleteById(id);
    }

    @Override
    public List<IntroduccionManual> findByManualCalidadId(Long idManualCalidad) {
        return introduccionManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

