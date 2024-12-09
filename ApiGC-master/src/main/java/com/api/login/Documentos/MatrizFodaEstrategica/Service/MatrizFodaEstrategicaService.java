package com.api.login.Documentos.MatrizFodaEstrategica.Service;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;

import java.util.List;

public interface MatrizFodaEstrategicaService {

    List<MatrizFodaEstrategica> findAll();

    MatrizFodaEstrategica findById(Long id);

    MatrizFodaEstrategica save(MatrizFodaEstrategica matrizFodaEstrategica);

    MatrizFodaEstrategica update(Long id, MatrizFodaEstrategica matrizFodaEstrategica);

    void deleteById(Long id);
}

