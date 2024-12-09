package com.api.login.Documentos.MejoraContinua.Service;

import com.api.login.Documentos.MejoraContinua.DTO.TablaMejoraContinuaDTO;

import java.util.List;

public interface TablaMejoraContinuaService {

    List<TablaMejoraContinuaDTO> findAll();

    TablaMejoraContinuaDTO findById(Long id);

    List<TablaMejoraContinuaDTO> findByMejoraContinua(Long idMejoraContinua);

    TablaMejoraContinuaDTO save(TablaMejoraContinuaDTO tablaDTO);

    TablaMejoraContinuaDTO update(Long id, TablaMejoraContinuaDTO tablaDTO);

    void deleteById(Long id);
}
