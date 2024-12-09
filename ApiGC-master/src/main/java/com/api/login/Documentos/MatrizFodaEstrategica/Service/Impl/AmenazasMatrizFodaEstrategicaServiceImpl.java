package com.api.login.Documentos.MatrizFodaEstrategica.Service.Impl;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.AmenazasMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Repository.AmenazasMatrizFodaEstrategicaRepository;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.AmenazasMatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AmenazasMatrizFodaEstrategicaServiceImpl implements AmenazasMatrizFodaEstrategicaService {

    @Autowired
    private AmenazasMatrizFodaEstrategicaRepository amenazasRepository;

    @Override
    public List<AmenazasMatrizFodaEstrategica> findAll() {
        return amenazasRepository.findAll();
    }

    @Override
    public List<AmenazasMatrizFodaEstrategica>
    findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica) {
        return amenazasRepository
                .findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(
                        idMatrizFodaEstrategica);
    }

    @Override
    public AmenazasMatrizFodaEstrategica findById(Long id) {
        Optional<AmenazasMatrizFodaEstrategica> optional =
                amenazasRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public AmenazasMatrizFodaEstrategica save(
            AmenazasMatrizFodaEstrategica amenazasMatrizFodaEstrategica) {
        return amenazasRepository.save(amenazasMatrizFodaEstrategica);
    }

    @Override
    public AmenazasMatrizFodaEstrategica update(Long id,
                                                AmenazasMatrizFodaEstrategica amenazasMatrizFodaEstrategica) {
        Optional<AmenazasMatrizFodaEstrategica> optional =
                amenazasRepository.findById(id);
        if (optional.isPresent()) {
            amenazasMatrizFodaEstrategica
                    .setIdAmenazasMatrizFodaEstrategica(id);
            return amenazasRepository.save(amenazasMatrizFodaEstrategica);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        amenazasRepository.deleteById(id);
    }
}

