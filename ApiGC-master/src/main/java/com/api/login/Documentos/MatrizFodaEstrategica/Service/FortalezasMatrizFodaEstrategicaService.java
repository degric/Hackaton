package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.FortalezasMatrizFodaEstrategica;

import java.util.List;

public interface FortalezasMatrizFodaEstrategicaService {

    List<FortalezasMatrizFodaEstrategica> findAll();

    List<FortalezasMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    FortalezasMatrizFodaEstrategica findById(Long id);

    FortalezasMatrizFodaEstrategica save(FortalezasMatrizFodaEstrategica fortalezasMatrizFodaEstrategica);

    FortalezasMatrizFodaEstrategica update(Long id, FortalezasMatrizFodaEstrategica fortalezasMatrizFodaEstrategica);

    void deleteById(Long id);
}

