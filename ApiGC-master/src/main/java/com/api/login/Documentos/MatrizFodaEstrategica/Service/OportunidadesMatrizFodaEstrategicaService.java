package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.OportunidadesMatrizFodaEstrategica;

import java.util.List;

public interface OportunidadesMatrizFodaEstrategicaService {

    List<OportunidadesMatrizFodaEstrategica> findAll();

    List<OportunidadesMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    OportunidadesMatrizFodaEstrategica findById(Long id);

    OportunidadesMatrizFodaEstrategica save(OportunidadesMatrizFodaEstrategica oportunidadesMatrizFodaEstrategica);

    OportunidadesMatrizFodaEstrategica update(Long id, OportunidadesMatrizFodaEstrategica oportunidadesMatrizFodaEstrategica);

    void deleteById(Long id);
}
