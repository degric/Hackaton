package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.Impl;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDDescricionDocumentoDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Mapper.LDDDescricionDocumentoMapper;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDDescricionDocumento;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.ListadoDistribucionDocumentos;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Repository.LDDDescricionDocumentoRepository;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Repository.ListadoDistribucionDocumentosRepository;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.LDDDescricionDocumentoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LDDDescricionDocumentoServiceImpl implements LDDDescricionDocumentoService {

    @Autowired
    private LDDDescricionDocumentoRepository lddDescricionDocumentoRepository;

    @Autowired
    private ListadoDistribucionDocumentosRepository listadoDistribucionDocumentosRepository;

    @Autowired
    private LDDDescricionDocumentoMapper lddDescricionDocumentoMapper;

    @Override
    public List<LDDDescricionDocumentoDTO> findAll() {
        return lddDescricionDocumentoRepository.findAll().stream()
                .map(lddDescricionDocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LDDDescricionDocumentoDTO findById(Long id) {
        LDDDescricionDocumento documento = lddDescricionDocumentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));
        return lddDescricionDocumentoMapper.toDTO(documento);
    }

    @Override
    public List<LDDDescricionDocumentoDTO> findByListadoDistribucionDocumentos(Long idListadoDistribucionDocumentos) {
        List<LDDDescricionDocumento> documentos = lddDescricionDocumentoRepository
                .findByListadoDistribucionDocumentos_IdListadoDistribucionDocumentos(idListadoDistribucionDocumentos);
        return documentos.stream()
                .map(lddDescricionDocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LDDDescricionDocumentoDTO save(LDDDescricionDocumentoDTO lddDescricionDocumentoDTO) {
        ListadoDistribucionDocumentos listadoDistribucionDocumentos = listadoDistribucionDocumentosRepository
                .findById(lddDescricionDocumentoDTO.getIdListadoDistribucionDocumentos())
                .orElseThrow(() -> new EntityNotFoundException("Listado de distribución no encontrado"));

        LDDDescricionDocumento documento = lddDescricionDocumentoMapper.toEntity(lddDescricionDocumentoDTO, listadoDistribucionDocumentos);
        LDDDescricionDocumento savedDocumento = lddDescricionDocumentoRepository.save(documento);
        return lddDescricionDocumentoMapper.toDTO(savedDocumento);
    }

    @Override
    public LDDDescricionDocumentoDTO update(Long id, LDDDescricionDocumentoDTO lddDescricionDocumentoDTO) {
        LDDDescricionDocumento existingDocumento = lddDescricionDocumentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));

        existingDocumento.setDescripcion(lddDescricionDocumentoDTO.getDescripcion());
        existingDocumento.setDocumento(lddDescricionDocumentoDTO.getDocumento());
        existingDocumento.setArea(lddDescricionDocumentoDTO.getArea());
        existingDocumento.setCodigoDocumento(lddDescricionDocumentoDTO.getCodigoDocumento());
        existingDocumento.setRevision(lddDescricionDocumentoDTO.getRevision());
        existingDocumento.setFechaImplantacion(lddDescricionDocumentoDTO.getFechaImplantacion());

        LDDDescricionDocumento updatedDocumento = lddDescricionDocumentoRepository.save(existingDocumento);
        return lddDescricionDocumentoMapper.toDTO(updatedDocumento);
    }

    @Override
    public void deleteById(Long id) {
        lddDescricionDocumentoRepository.deleteById(id);
    }
}

