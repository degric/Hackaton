package com.api.login.service;

import com.api.login.DTO.ReclamoCompraDTO;

import java.util.List;
import java.util.Optional;

public interface ReclamoCompraService {

    List<ReclamoCompraDTO> GetAll();

    Optional<ReclamoCompraDTO> GetById(Integer id);

    ReclamoCompraDTO Crear(ReclamoCompraDTO dto);

    ReclamoCompraDTO Actualizar(Integer id, ReclamoCompraDTO dto);

    void Eliminar(Integer id);
}
