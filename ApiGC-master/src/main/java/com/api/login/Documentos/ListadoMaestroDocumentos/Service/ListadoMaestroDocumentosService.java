package com.api.login.Documentos.ListadoMaestroDocumentos.Service;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.ListadoMaestroDocumentosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface ListadoMaestroDocumentosService {

    List<ListadoMaestroDocumentos> findAll();

    ListadoMaestroDocumentos findById(Long id);

    ListadoMaestroDocumentos save(ListadoMaestroDocumentos listadoMaestroDocumentos);

    ListadoMaestroDocumentos update(Long id, ListadoMaestroDocumentosDTO listadoMaestroDocumentosDTO);

    void deleteById(Long id);


    // Nuevo método para generar el reporte PDF
    byte[] generarListadoMaestroPdf(Long id) throws DocumentException;
}

