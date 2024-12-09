package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.pojo.TablaEvaluacionDesempenoManual;
import com.api.login.ManualDeCalidad.Dao.TablaEvaluacionDesempenoManualDao;
import com.api.login.ManualDeCalidad.Service.TablaEvaluacionDesempenoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablaEvaluacionDesempenoManualServiceImpl implements TablaEvaluacionDesempenoManualService {

    @Autowired
    private TablaEvaluacionDesempenoManualDao tablaEvaluacionDesempenoManualRepository;

    @Override
    public List<TablaEvaluacionDesempenoManual> findAll() {
        return tablaEvaluacionDesempenoManualRepository.findAll();
    }

    @Override
    public TablaEvaluacionDesempenoManual findById(Long id) {
        Optional<TablaEvaluacionDesempenoManual> optionalTablaEvaluacionDesempenoManual = tablaEvaluacionDesempenoManualRepository.findById(id);
        return optionalTablaEvaluacionDesempenoManual.orElse(null);
    }

    @Override
    public TablaEvaluacionDesempenoManual save(TablaEvaluacionDesempenoManual tablaEvaluacionDesempenoManual) {
        return tablaEvaluacionDesempenoManualRepository.save(tablaEvaluacionDesempenoManual);
    }

    @Override
    public TablaEvaluacionDesempenoManual update(Long id, TablaEvaluacionDesempenoManual tablaEvaluacionDesempenoManual) {
        Optional<TablaEvaluacionDesempenoManual> optionalTablaEvaluacionDesempenoManual = tablaEvaluacionDesempenoManualRepository.findById(id);
        if (optionalTablaEvaluacionDesempenoManual.isPresent()) {
            tablaEvaluacionDesempenoManual.setIdTablaEvaluacionDesempenoManual(id);
            return tablaEvaluacionDesempenoManualRepository.save(tablaEvaluacionDesempenoManual);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        tablaEvaluacionDesempenoManualRepository.deleteById(id);
    }

    @Override
    public List<TablaEvaluacionDesempenoManual> findByManualCalidadId(Long idManualCalidad) {
        return tablaEvaluacionDesempenoManualRepository.findByManualCalidadIdManualCalidad(idManualCalidad);
    }
}

