package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.MatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MatrizFodaEstrategicaServiceImpl implements MatrizFodaEstrategicaService {

    @Autowired
    private MatrizFodaEstrategicaRepository matrizFodaEstrategicaRepository;

    @Override
    public List<MatrizFodaEstrategica> findAll() {
        return matrizFodaEstrategicaRepository.findAll();
    }

    @Override
    public MatrizFodaEstrategica findById(Long id) {
        Optional<MatrizFodaEstrategica> optional = matrizFodaEstrategicaRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public MatrizFodaEstrategica save(MatrizFodaEstrategica matrizFodaEstrategica) {
        return matrizFodaEstrategicaRepository.save(matrizFodaEstrategica);
    }

    @Override
    public MatrizFodaEstrategica update(Long id, MatrizFodaEstrategica matrizFodaEstrategica) {
        Optional<MatrizFodaEstrategica> optional = matrizFodaEstrategicaRepository.findById(id);
        if (optional.isPresent()) {
            matrizFodaEstrategica.setIdMatrizFodaEstrategica(id);
            return matrizFodaEstrategicaRepository.save(matrizFodaEstrategica);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        matrizFodaEstrategicaRepository.deleteById(id);
    }
}

