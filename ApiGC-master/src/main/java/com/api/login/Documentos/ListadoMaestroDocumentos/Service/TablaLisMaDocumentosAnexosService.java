package com.api.login.Documentos.ListadoMaestroDocumentos.Service;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosAnexosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosAnexos;

import java.util.List;

public interface TablaLisMaDocumentosAnexosService {

    // Método para obtener todos los anexos como DTOs
    List<TablaLisMaDocumentosAnexosDTO> findAllDTOs();

    // Método para obtener un anexo por ID como DTO
    TablaLisMaDocumentosAnexosDTO findDTOById(Long id);

    // Método para obtener anexos por idListadoMaestroDocumentos como DTOs
    List<TablaLisMaDocumentosAnexosDTO> findDTOsByListadoMaestroDocumentos(Long idListadoMaestroDocumentos);

    // Método para crear un nuevo anexo
    TablaLisMaDocumentosAnexosDTO createAnexo(TablaLisMaDocumentosAnexosDTO tablaLisMaDocumentosAnexosDTO);

    // Método para actualizar un anexo existente
    TablaLisMaDocumentosAnexosDTO updateAnexo(Long id, TablaLisMaDocumentosAnexosDTO tablaLisMaDocumentosAnexosDTO);

    // Método para eliminar un anexo por ID
    void deleteAnexo(Long id);
}
