package com.api.login.Documentos.ConstanciaInduccion.Service;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ConstanciaInduccionDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface ConstanciaInduccionService {

    List<ConstanciaInduccionDTO> findAll();

    ConstanciaInduccionDTO findById(Long id);

    ConstanciaInduccionDTO save(ConstanciaInduccionDTO dto);

    ConstanciaInduccionDTO update(Long id, ConstanciaInduccionDTO dto);

    void deleteById(Long id);

    byte[] generarPdf(Long id) throws DocumentException;
}
