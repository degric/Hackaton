package com.api.login.Documentos.ControlDocumentosExternos.Service;

import com.api.login.Documentos.ControlDocumentosExternos.Pojo.TablaControlDocumentosExternos;

import java.util.List;

public interface TablaControlDocumentosExternosService {

    List<TablaControlDocumentosExternos> findAll();

    TablaControlDocumentosExternos findById(Long id);

    TablaControlDocumentosExternos save(TablaControlDocumentosExternos tablaControlDocumentosExternos);

    TablaControlDocumentosExternos update(Long id, TablaControlDocumentosExternos tablaControlDocumentosExternos);

    void deleteById(Long id);

    List<TablaControlDocumentosExternos> findByEncabezado(Long id);
}

