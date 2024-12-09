package com.api.login.Documentos.ConstanciaInduccion.Service;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradoresConsInduDTO;

import java.util.List;

public interface ColaboradoresConsInduService {

    List<ColaboradoresConsInduDTO> findAll();

    ColaboradoresConsInduDTO findById(Long id);

    List<ColaboradoresConsInduDTO> findByConstanciaInduccionId(Long idConstanciaInduccion);

    ColaboradoresConsInduDTO save(ColaboradoresConsInduDTO dto);

    ColaboradoresConsInduDTO update(Long id, ColaboradoresConsInduDTO dto);

    void deleteById(Long id);
}
