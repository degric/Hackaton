package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.AmenazasMatrizFodaEstrategica;

import java.util.List;

public interface AmenazasMatrizFodaEstrategicaService {

    List<AmenazasMatrizFodaEstrategica> findAll();

    List<AmenazasMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    AmenazasMatrizFodaEstrategica findById(Long id);

    AmenazasMatrizFodaEstrategica save(AmenazasMatrizFodaEstrategica amenazasMatrizFodaEstrategica);

    AmenazasMatrizFodaEstrategica update(Long id, AmenazasMatrizFodaEstrategica amenazasMatrizFodaEstrategica);

    void deleteById(Long id);
}
