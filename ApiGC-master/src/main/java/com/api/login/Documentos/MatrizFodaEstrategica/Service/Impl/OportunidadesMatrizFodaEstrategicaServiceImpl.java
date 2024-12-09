package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.OportunidadesMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.OportunidadesMatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.OportunidadesMatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OportunidadesMatrizFodaEstrategicaServiceImpl implements OportunidadesMatrizFodaEstrategicaService {

    @Autowired
    private OportunidadesMatrizFodaEstrategicaRepository oportunidadesRepository;

    @Override
    public List<OportunidadesMatrizFodaEstrategica> findAll() {
        return oportunidadesRepository.findAll();
    }

    @Override
    public List<OportunidadesMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return oportunidadesRepository.findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(idMatrizFodaEstrategica);
    }

    @Override
    public OportunidadesMatrizFodaEstrategica findById(Long id) {
        Optional<OportunidadesMatrizFodaEstrategica> optional = oportunidadesRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public OportunidadesMatrizFodaEstrategica save(OportunidadesMatrizFodaEstrategica oportunidadesMatrizFodaEstrategica) {
        return oportunidadesRepository.save(oportunidadesMatrizFodaEstrategica);
    }

    @Override
    public OportunidadesMatrizFodaEstrategica update(Long id, OportunidadesMatrizFodaEstrategica oportunidadesMatrizFodaEstrategica) {
        Optional<OportunidadesMatrizFodaEstrategica> optional = oportunidadesRepository.findById(id);
        if (optional.isPresent()) {
            oportunidadesMatrizFodaEstrategica.setIdOportunidadesMatrizFodaEstrategica(id);
            return oportunidadesRepository.save(oportunidadesMatrizFodaEstrategica);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        oportunidadesRepository.deleteById(id);
    }
}
