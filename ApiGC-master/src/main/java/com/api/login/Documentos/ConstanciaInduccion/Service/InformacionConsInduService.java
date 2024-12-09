package com.api.login.Documentos.ConstanciaInduccion.Service;

import com.api.login.Documentos.ConstanciaInduccion.DTO.InformacionConsInduDTO;

import java.util.List;

public interface InformacionConsInduService {

    List<InformacionConsInduDTO> findAll();

    InformacionConsInduDTO findById(Long id);

    List<InformacionConsInduDTO> findByConstanciaInduccionId(Long idConstanciaInduccion);

    InformacionConsInduDTO save(InformacionConsInduDTO dto);

    InformacionConsInduDTO update(Long id, InformacionConsInduDTO dto);

    void deleteById(Long id);
}

