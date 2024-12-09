package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.DebilidadesMatrizFodaEstrategica;

import java.util.List;

public interface DebilidadesMatrizFodaEstrategicaService {

    List<DebilidadesMatrizFodaEstrategica> findAll();

    List<DebilidadesMatrizFodaEstrategica> findByMatrizFodaEstrategicaId(Long idMatrizFodaEstrategica);

    DebilidadesMatrizFodaEstrategica findById(Long id);

    DebilidadesMatrizFodaEstrategica save(DebilidadesMatrizFodaEstrategica debilidadesMatrizFodaEstrategica);

    DebilidadesMatrizFodaEstrategica update(Long id, DebilidadesMatrizFodaEstrategica debilidadesMatrizFodaEstrategica);

    void deleteById(Long id);
}
