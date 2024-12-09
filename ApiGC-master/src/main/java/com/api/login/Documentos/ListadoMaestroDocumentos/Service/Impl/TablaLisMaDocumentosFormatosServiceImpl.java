package com.api.login.Documentos.ListadoMaestroDocumentos.Service.Impl;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosFormatosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Mapper.TablaLisMaDocumentosFormatosMapper;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosFormatos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.ListadoMaestroDocumentosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.TablaLisMaDocumentosFormatosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.TablaLisMaDocumentosFormatosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablaLisMaDocumentosFormatosServiceImpl implements TablaLisMaDocumentosFormatosService {

    @Autowired
    private TablaLisMaDocumentosFormatosRepository tablaLisMaDocumentosFormatosRepository;

    @Autowired
    private ListadoMaestroDocumentosRepository listadoMaestroDocumentosRepository;

    @Autowired
    private TablaLisMaDocumentosFormatosMapper tablaLisMaDocumentosFormatosMapper;

    @Override
    public List<TablaLisMaDocumentosFormatos> findAll() {
        return tablaLisMaDocumentosFormatosRepository.findAll();
    }

    @Override
    public TablaLisMaDocumentosFormatos findById(Long id) {
        return tablaLisMaDocumentosFormatosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos no encontrados"));
    }

    @Override
    public List<TablaLisMaDocumentosFormatos> findByListadoMaestroDocumentos(Long idListadoMaestroDocumentos) {
        return tablaLisMaDocumentosFormatosRepository.findByListadoMaestroDocumentos_IdListadoMaestroDocumentos(idListadoMaestroDocumentos);
    }

    @Override
    public TablaLisMaDocumentosFormatos save(TablaLisMaDocumentosFormatos tablaLisMaDocumentosFormatos) {
        return tablaLisMaDocumentosFormatosRepository.save(tablaLisMaDocumentosFormatos);
    }

    @Override
    public TablaLisMaDocumentosFormatos update(Long id, TablaLisMaDocumentosFormatosDTO tablaLisMaDocumentosFormatosDTO) {
        TablaLisMaDocumentosFormatos existingFormato = tablaLisMaDocumentosFormatosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formato no encontrado"));

        existingFormato.setCodigo(tablaLisMaDocumentosFormatosDTO.getCodigo());
        existingFormato.setNombredocumento(tablaLisMaDocumentosFormatosDTO.getNombredocumento());
        existingFormato.setDepartamento(tablaLisMaDocumentosFormatosDTO.getDepartamento());
        existingFormato.setResponsable(tablaLisMaDocumentosFormatosDTO.getResponsable());
        existingFormato.setNoRevision(tablaLisMaDocumentosFormatosDTO.getNoRevision());
        existingFormato.setElaborado(tablaLisMaDocumentosFormatosDTO.getElaborado());
        existingFormato.setRevisado(tablaLisMaDocumentosFormatosDTO.getRevisado());
        existingFormato.setModificado(tablaLisMaDocumentosFormatosDTO.getModificado());

        return tablaLisMaDocumentosFormatosRepository.save(existingFormato);
    }


    @Override
    public void deleteById(Long id) {
        tablaLisMaDocumentosFormatosRepository.deleteById(id);
    }
}

