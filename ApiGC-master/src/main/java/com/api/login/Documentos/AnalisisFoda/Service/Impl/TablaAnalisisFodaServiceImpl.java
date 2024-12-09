package com.api.login.Documentos.AnalisisFoda.Service.Impl;

import com.api.login.Documentos.AnalisisFoda.Pojo.TablaAnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Repository.TablaAnalisisFodaRepository;
import com.api.login.Documentos.AnalisisFoda.Service.TablaAnalisisFodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TablaAnalisisFodaServiceImpl implements TablaAnalisisFodaService {

    @Autowired
    private TablaAnalisisFodaRepository tablaAnalisisFodaRepository;

    @Override
    public List<TablaAnalisisFoda> findAll() {
        return tablaAnalisisFodaRepository.findAll();
    }

    @Override
    public List<TablaAnalisisFoda> findByAnalisisFodaId(Long idAnalisisFoda) {
        return tablaAnalisisFodaRepository.findByAnalisisFoda_IdAnalisisFoda(idAnalisisFoda);
    }

    @Override
    public TablaAnalisisFoda findById(Long id) {
        Optional<TablaAnalisisFoda> optional = tablaAnalisisFodaRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public TablaAnalisisFoda save(TablaAnalisisFoda tablaAnalisisFoda) {
        return tablaAnalisisFodaRepository.save(tablaAnalisisFoda);
    }

    @Override
    public TablaAnalisisFoda update(Long id, TablaAnalisisFoda tablaAnalisisFoda) {
        Optional<TablaAnalisisFoda> optional = tablaAnalisisFodaRepository.findById(id);
        if (optional.isPresent()) {
            tablaAnalisisFoda.setIdTablaAnalisisFoda(id);
            return tablaAnalisisFodaRepository.save(tablaAnalisisFoda);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        tablaAnalisisFodaRepository.deleteById(id);
    }
}

