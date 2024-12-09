package com.api.login.Documentos.AnalisisFoda.Service;

import com.api.login.Documentos.AnalisisFoda.DTO.AnalisisFodaDTOSinListas;
import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;

import java.util.List;

public interface AnalisisFodaService {

    List<AnalisisFoda> findAll();

    AnalisisFoda findById(Long id);

    AnalisisFoda save(AnalisisFoda analisisFoda);

    AnalisisFoda update(Long id, AnalisisFodaDTOSinListas AnalisisFodaDTO);

    void deleteById(Long id);
}

