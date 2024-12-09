package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.ListadoDistribucionDocumentosDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface ListadoDistribucionDocumentosService {

    List<ListadoDistribucionDocumentosDTO> findAll();

    ListadoDistribucionDocumentosDTO findById(Long id);

    ListadoDistribucionDocumentosDTO save(ListadoDistribucionDocumentosDTO listadoDistribucionDocumentosDTO);

    ListadoDistribucionDocumentosDTO update(Long id, ListadoDistribucionDocumentosDTO listadoDistribucionDocumentosDTO);

    void deleteById(Long id);

    byte[] generarReportePdf(Long id) throws DocumentException;
}
