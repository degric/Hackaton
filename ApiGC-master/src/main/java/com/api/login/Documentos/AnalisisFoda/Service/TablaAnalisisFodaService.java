package com.api.login.Documentos.AnalisisFoda.Service;

import com.api.login.Documentos.AnalisisFoda.Pojo.TablaAnalisisFoda;

import java.util.List;

public interface TablaAnalisisFodaService {

    List<TablaAnalisisFoda> findAll();

    List<TablaAnalisisFoda> findByAnalisisFodaId(Long idAnalisisFoda);

    TablaAnalisisFoda findById(Long id);

    TablaAnalisisFoda save(TablaAnalisisFoda tablaAnalisisFoda);

    TablaAnalisisFoda update(Long id, TablaAnalisisFoda tablaAnalisisFoda);

    void deleteById(Long id);
}

