package com.api.login.Documentos.ListadoMaestroDocumentos.Service.Impl;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosAnexosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Mapper.TablaLisMaDocumentosAnexosMapper;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosAnexos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.ListadoMaestroDocumentosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.TablaLisMaDocumentosAnexosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.TablaLisMaDocumentosAnexosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TablaLisMaDocumentosAnexosServiceImpl implements TablaLisMaDocumentosAnexosService {

    @Autowired
    private TablaLisMaDocumentosAnexosRepository tablaLisMaDocumentosAnexosRepository;

    @Autowired
    private ListadoMaestroDocumentosRepository listadoMaestroDocumentosRepository;

    @Autowired
    private TablaLisMaDocumentosAnexosMapper tablaLisMaDocumentosAnexosMapper;

    @Override
    public List<TablaLisMaDocumentosAnexosDTO> findAllDTOs() {
        List<TablaLisMaDocumentosAnexos> anexos = tablaLisMaDocumentosAnexosRepository.findAll();
        return anexos.stream()
                .map(tablaLisMaDocumentosAnexosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaLisMaDocumentosAnexosDTO findDTOById(Long id) {
        TablaLisMaDocumentosAnexos anexo = tablaLisMaDocumentosAnexosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Anexo no encontrado"));
        return tablaLisMaDocumentosAnexosMapper.toDTO(anexo);
    }

    @Override
    public List<TablaLisMaDocumentosAnexosDTO> findDTOsByListadoMaestroDocumentos(Long idListadoMaestroDocumentos) {
        List<TablaLisMaDocumentosAnexos> anexos = tablaLisMaDocumentosAnexosRepository.findByListadoMaestroDocumentos_IdListadoMaestroDocumentos(idListadoMaestroDocumentos);
        return anexos.stream()
                .map(tablaLisMaDocumentosAnexosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaLisMaDocumentosAnexosDTO createAnexo(TablaLisMaDocumentosAnexosDTO tablaLisMaDocumentosAnexosDTO) {
        ListadoMaestroDocumentos listadoMaestroDocumentos = listadoMaestroDocumentosRepository
                .findById(tablaLisMaDocumentosAnexosDTO.getIdListadoMaestroDocumentos())
                .orElseThrow(() -> new EntityNotFoundException("Listado Maestro no encontrado"));

        TablaLisMaDocumentosAnexos anexo = tablaLisMaDocumentosAnexosMapper.toEntity(tablaLisMaDocumentosAnexosDTO, listadoMaestroDocumentos);
        TablaLisMaDocumentosAnexos savedAnexo = tablaLisMaDocumentosAnexosRepository.save(anexo);
        return tablaLisMaDocumentosAnexosMapper.toDTO(savedAnexo);
    }

    @Override
    public TablaLisMaDocumentosAnexosDTO updateAnexo(Long id, TablaLisMaDocumentosAnexosDTO tablaLisMaDocumentosAnexosDTO) {
        TablaLisMaDocumentosAnexos existingAnexo = tablaLisMaDocumentosAnexosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Anexo no encontrado"));

        existingAnexo.setCodigo(tablaLisMaDocumentosAnexosDTO.getCodigo());
        existingAnexo.setNombredocumento(tablaLisMaDocumentosAnexosDTO.getNombredocumento());
        existingAnexo.setDepartamento(tablaLisMaDocumentosAnexosDTO.getDepartamento());
        existingAnexo.setResponsable(tablaLisMaDocumentosAnexosDTO.getResponsable());
        existingAnexo.setNoRevision(tablaLisMaDocumentosAnexosDTO.getNoRevision());
        existingAnexo.setElaborado(tablaLisMaDocumentosAnexosDTO.getElaborado());
        existingAnexo.setRevisado(tablaLisMaDocumentosAnexosDTO.getRevisado());
        existingAnexo.setModificado(tablaLisMaDocumentosAnexosDTO.getModificado());

        TablaLisMaDocumentosAnexos updatedAnexo = tablaLisMaDocumentosAnexosRepository.save(existingAnexo);
        return tablaLisMaDocumentosAnexosMapper.toDTO(updatedAnexo);
    }

    @Override
    public void deleteAnexo(Long id) {
        tablaLisMaDocumentosAnexosRepository.deleteById(id);
    }
}


