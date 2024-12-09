package com.api.login.Documentos.ListadoMaestroDocumentos.Service.Impl;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosProcesosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Mapper.TablaLisMaDocumentosProcesosMapper;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosProcesos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.ListadoMaestroDocumentosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.TablaLisMaDocumentosProcesosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.TablaLisMaDocumentosProcesosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class TablaLisMaDocumentosProcesosServiceImpl implements TablaLisMaDocumentosProcesosService {

    @Autowired
    private TablaLisMaDocumentosProcesosRepository tablaLisMaDocumentosProcesosRepository;

    @Autowired
    private ListadoMaestroDocumentosRepository listadoMaestroDocumentosRepository;

    @Autowired
    private TablaLisMaDocumentosProcesosMapper tablaLisMaDocumentosProcesosMapper;

    @Override
    public List<TablaLisMaDocumentosProcesos> findAll() {
        return tablaLisMaDocumentosProcesosRepository.findAll();
    }

    @Override
    public TablaLisMaDocumentosProcesos findById(Long id) {
        return tablaLisMaDocumentosProcesosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos no encontrados"));
    }

    @Override
    public List<TablaLisMaDocumentosProcesos> findByListadoMaestroDocumentos(Long idListadoMaestroDocumentos) {
        return tablaLisMaDocumentosProcesosRepository.findByListadoMaestroDocumentos_IdListadoMaestroDocumentos(idListadoMaestroDocumentos);
    }

    @Override
    public TablaLisMaDocumentosProcesos save(TablaLisMaDocumentosProcesos tablaLisMaDocumentosProcesos) {
        return tablaLisMaDocumentosProcesosRepository.save(tablaLisMaDocumentosProcesos);
    }

    @Override
    public TablaLisMaDocumentosProcesos update(Long id, TablaLisMaDocumentosProcesosDTO tablaLisMaDocumentosProcesosDTO) {
        TablaLisMaDocumentosProcesos existingProceso = tablaLisMaDocumentosProcesosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proceso no encontrado"));

        existingProceso.setCodigo(tablaLisMaDocumentosProcesosDTO.getCodigo());
        existingProceso.setNombredocumento(tablaLisMaDocumentosProcesosDTO.getNombredocumento());
        existingProceso.setDepartamento(tablaLisMaDocumentosProcesosDTO.getDepartamento());
        existingProceso.setResponsable(tablaLisMaDocumentosProcesosDTO.getResponsable());
        existingProceso.setNoRevision(tablaLisMaDocumentosProcesosDTO.getNoRevision());
        existingProceso.setElaborado(tablaLisMaDocumentosProcesosDTO.getElaborado());
        existingProceso.setRevisado(tablaLisMaDocumentosProcesosDTO.getRevisado());
        existingProceso.setModificado(tablaLisMaDocumentosProcesosDTO.getModificado());

        return tablaLisMaDocumentosProcesosRepository.save(existingProceso);
    }

    @Override
    public void deleteById(Long id) {
        tablaLisMaDocumentosProcesosRepository.deleteById(id);
    }
}


