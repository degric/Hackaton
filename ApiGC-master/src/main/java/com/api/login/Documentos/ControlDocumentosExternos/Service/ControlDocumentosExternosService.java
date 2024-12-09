package com.api.login.Documentos.ControlDocumentosExternos.Service;

import com.api.login.Documentos.ControlDocumentosExternos.DTO.ControlDocumentosExternosDTO;
import com.api.login.Documentos.ControlDocumentosExternos.DTO.ControlDocumentosExternosDTOSinListas;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface ControlDocumentosExternosService {

    List<ControlDocumentosExternos> findAll();

    ControlDocumentosExternos findById(Long id);

    ControlDocumentosExternos save(ControlDocumentosExternos controlDocumentosExternos);

    ControlDocumentosExternos update(Long id, ControlDocumentosExternosDTOSinListas controlDocumentosExternosDTO);

    void deleteById(Long id);

    byte[] generarReportePdf(Long id) throws DocumentException;
}

