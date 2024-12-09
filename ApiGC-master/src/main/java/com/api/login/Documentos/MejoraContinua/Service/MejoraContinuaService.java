package com.api.login.Documentos.MejoraContinua.Service;

import com.api.login.Documentos.MejoraContinua.DTO.MejoraContinuaDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface MejoraContinuaService {

    List<MejoraContinuaDTO> findAll();

    MejoraContinuaDTO findById(Long id);

    MejoraContinuaDTO save(MejoraContinuaDTO mejoraContinuaDTO);

    MejoraContinuaDTO update(Long id, MejoraContinuaDTO mejoraContinuaDTO);

    void deleteById(Long id);

    byte[] generarPdf(Long id) throws DocumentException;
}
