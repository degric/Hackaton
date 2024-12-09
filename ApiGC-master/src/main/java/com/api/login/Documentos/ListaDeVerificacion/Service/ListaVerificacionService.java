package com.api.login.Documentos.ListaDeVerificacion.Service;

import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionDTO;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface ListaVerificacionService {

    List<ListaVerificacionDTO> findAll();

    ListaVerificacionDTO findById(Long id);

    ListaVerificacionDTO save(ListaVerificacionDTO listaVerificacionDTO);

    ListaVerificacionDTO update(Long id, ListaVerificacionDTO listaVerificacionDTO);

    void deleteById(Long id);

    public byte[] generarBSCPdf(Long id) throws DocumentException;
    }

