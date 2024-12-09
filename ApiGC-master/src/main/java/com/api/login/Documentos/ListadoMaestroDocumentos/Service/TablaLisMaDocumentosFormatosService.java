package com.api.login.Documentos.ListadoMaestroDocumentos.Service;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosFormatosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosFormatos;

import java.util.List;

public interface TablaLisMaDocumentosFormatosService {

    List<TablaLisMaDocumentosFormatos> findAll();

    TablaLisMaDocumentosFormatos findById(Long id);

    List<TablaLisMaDocumentosFormatos> findByListadoMaestroDocumentos(Long idListadoMaestroDocumentos);

    TablaLisMaDocumentosFormatos save(TablaLisMaDocumentosFormatos tablaLisMaDocumentosFormatos);

    TablaLisMaDocumentosFormatos update(Long id, TablaLisMaDocumentosFormatosDTO tablaLisMaDocumentosFormatosDTO);

    void deleteById(Long id);
}

