package com.api.login.Documentos.ConstanciaInduccion.Service;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradorConsInducDTO;

import java.util.List;

public interface ColaboradorConsInducService {

    List<ColaboradorConsInducDTO> findAll();

    ColaboradorConsInducDTO findById(Long id);

    ColaboradorConsInducDTO findByConstanciaInduccionId(Long idConstanciaInduccion);

    ColaboradorConsInducDTO save(ColaboradorConsInducDTO dto);

    ColaboradorConsInducDTO update(Long id, ColaboradorConsInducDTO dto);

    void deleteById(Long id);
}
