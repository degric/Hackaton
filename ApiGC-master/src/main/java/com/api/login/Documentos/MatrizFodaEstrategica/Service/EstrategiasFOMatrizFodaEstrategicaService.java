package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFOMatrizFodaEstrategica;

import java.util.List;

public interface EstrategiasFOMatrizFodaEstrategicaService {

    List<EstrategiasFOMatrizFodaEstrategica> findAll();

    List<EstrategiasFOMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    EstrategiasFOMatrizFodaEstrategica findById(Long id);

    EstrategiasFOMatrizFodaEstrategica save(EstrategiasFOMatrizFodaEstrategica estrategiasFOMatrizFodaEstrategica);

    EstrategiasFOMatrizFodaEstrategica update(Long id, EstrategiasFOMatrizFodaEstrategica estrategiasFOMatrizFodaEstrategica);

    void deleteById(Long id);
}

