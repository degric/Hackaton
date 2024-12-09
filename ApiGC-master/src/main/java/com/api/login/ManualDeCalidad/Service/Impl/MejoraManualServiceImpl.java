package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.MejoraManual;
import com.api.login.ManualDeCalidad.Dao.MejoraManualDao;
import com.api.login.ManualDeCalidad.Service.MejoraManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MejoraManualServiceImpl implements MejoraManualService {

    @Autowired
    private MejoraManualDao mejoraRepository;

    @Override
    public List<MejoraManual> findAll() {
        return mejoraRepository.findAll();
    }

    @Override
    public MejoraManual findById(Long id) {
        Optional<MejoraManual> optionalMejora = mejoraRepository.findById(id);
        return optionalMejora.orElse(null);
    }

    @Override
    public MejoraManual save(MejoraManual mejoraManual) {
        return mejoraRepository.save(mejoraManual);
    }

    @Override
    public MejoraManual update(Long id, MejoraManual mejoraManual) {
        Optional<MejoraManual> optionalMejora = mejoraRepository.findById(id);
        if (optionalMejora.isPresent()) {
            mejoraManual.setIdMejora(id);
            return mejoraRepository.save(mejoraManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        mejoraRepository.deleteById(id);
    }

    @Override
    public List<MejoraManual> findByManualCalidadId(Long idManualCalidad) {
        return mejoraRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

