package com.api.login.Documentos.MejoraContinua.Service;

import com.api.login.Documentos.MejoraContinua.DTO.DatosMejoraContinuaDTO;

import java.util.List;

public interface DatosMejoraContinuaService {

    List<DatosMejoraContinuaDTO> findAll();

    DatosMejoraContinuaDTO findById(Long id);

    DatosMejoraContinuaDTO findByMejoraContinua(Long idMejoraContinua);

    DatosMejoraContinuaDTO save(DatosMejoraContinuaDTO datosDTO);

    DatosMejoraContinuaDTO update(Long id, DatosMejoraContinuaDTO datosDTO);

    void deleteById(Long id);
}
