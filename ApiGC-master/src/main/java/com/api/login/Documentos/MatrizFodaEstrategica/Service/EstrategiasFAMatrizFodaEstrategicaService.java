package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFAMatrizFodaEstrategica;

import java.util.List;

public interface EstrategiasFAMatrizFodaEstrategicaService {

    List<EstrategiasFAMatrizFodaEstrategica> findAll();

    List<EstrategiasFAMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    EstrategiasFAMatrizFodaEstrategica findById(Long id);

    EstrategiasFAMatrizFodaEstrategica save(EstrategiasFAMatrizFodaEstrategica estrategiasFAMatrizFodaEstrategica);

    EstrategiasFAMatrizFodaEstrategica update(Long id, EstrategiasFAMatrizFodaEstrategica estrategiasFAMatrizFodaEstrategica);

    void deleteById(Long id);
}

