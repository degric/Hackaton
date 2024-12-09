package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDOMatrizFodaEstrategica;

import java.util.List;

public interface EstrategiasDOMatrizFodaEstrategicaService {

    List<EstrategiasDOMatrizFodaEstrategica> findAll();

    List<EstrategiasDOMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    EstrategiasDOMatrizFodaEstrategica findById(Long id);

    EstrategiasDOMatrizFodaEstrategica save(EstrategiasDOMatrizFodaEstrategica estrategiasDOMatrizFodaEstrategica);

    EstrategiasDOMatrizFodaEstrategica update(Long id, EstrategiasDOMatrizFodaEstrategica estrategiasDOMatrizFodaEstrategica);

    void deleteById(Long id);
}
