package com.api.login.Documentos.ListadoMaestroDocumentos.Service;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosProcesosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosProcesos;

import java.util.List;

public interface TablaLisMaDocumentosProcesosService {

    List<TablaLisMaDocumentosProcesos> findAll();

    TablaLisMaDocumentosProcesos findById(Long id);

    List<TablaLisMaDocumentosProcesos> findByListadoMaestroDocumentos(Long idListadoMaestroDocumentos);

    TablaLisMaDocumentosProcesos save(TablaLisMaDocumentosProcesos tablaLisMaDocumentosProcesos);

    TablaLisMaDocumentosProcesos update(Long id, TablaLisMaDocumentosProcesosDTO tablaLisMaDocumentosProcesosDTO);

    void deleteById(Long id);
}



