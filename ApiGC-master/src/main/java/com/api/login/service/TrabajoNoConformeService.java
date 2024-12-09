package com.api.login.service;

import com.api.login.DTO.TrabajoNoConformeDTO;

import java.util.List;

public interface TrabajoNoConformeService {

    List<TrabajoNoConformeDTO> getAll();

    TrabajoNoConformeDTO create(TrabajoNoConformeDTO trabajoNoConformeDTO);

    TrabajoNoConformeDTO update(Integer id, TrabajoNoConformeDTO trabajoNoConformeDTO);

    void eliminar(Integer id);
}
