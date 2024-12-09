package com.api.login.Documentos.MejoraContinua.Service;

import com.api.login.Documentos.MejoraContinua.DTO.IntegrantesMejoraContinuaDTO;

import java.util.List;

public interface IntegrantesMejoraContinuaService {

    List<IntegrantesMejoraContinuaDTO> findAll();

    IntegrantesMejoraContinuaDTO findById(Long id);

    List<IntegrantesMejoraContinuaDTO> findByMejoraContinua(Long idMejoraContinua);

    IntegrantesMejoraContinuaDTO save(IntegrantesMejoraContinuaDTO integranteDTO);

    IntegrantesMejoraContinuaDTO update(Long id, IntegrantesMejoraContinuaDTO integranteDTO);

    void deleteById(Long id);
}
