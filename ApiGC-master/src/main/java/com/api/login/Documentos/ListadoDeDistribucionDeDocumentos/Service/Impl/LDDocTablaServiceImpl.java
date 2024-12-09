package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.Impl;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDocTablaDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Mapper.LDDocTablaMapper;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDocTabla;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.ListadoDistribucionDocumentos;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Repository.LDDocTablaRepository;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Repository.ListadoDistribucionDocumentosRepository;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.LDDocTablaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LDDocTablaServiceImpl implements LDDocTablaService {

    @Autowired
    private LDDocTablaRepository lddDocTablaRepository;

    @Autowired
    private ListadoDistribucionDocumentosRepository listadoDistribucionDocumentosRepository;

    @Autowired
    private LDDocTablaMapper lddDocTablaMapper;

    @Override
    public List<LDDocTablaDTO> findAll() {
        return lddDocTablaRepository.findAll().stream()
                .map(lddDocTablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LDDocTablaDTO findById(Long id) {
        LDDocTabla docTabla = lddDocTablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));
        return lddDocTablaMapper.toDTO(docTabla);
    }

    @Override
    public List<LDDocTablaDTO> findByListadoDistribucionDocumentos(Long idListadoDistribucionDocumentos) {
        List<LDDocTabla> documentos = lddDocTablaRepository
                .findByListadoDistribucionDocumentos_IdListadoDistribucionDocumentos(idListadoDistribucionDocumentos);
        return documentos.stream()
                .map(lddDocTablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LDDocTablaDTO save(LDDocTablaDTO lddDocTablaDTO) {
        ListadoDistribucionDocumentos listadoDistribucionDocumentos = listadoDistribucionDocumentosRepository
                .findById(lddDocTablaDTO.getIdListadoDistribucionDocumentos())
                .orElseThrow(() -> new EntityNotFoundException("Listado de distribución no encontrado"));

        LDDocTabla docTabla = lddDocTablaMapper.toEntity(lddDocTablaDTO, listadoDistribucionDocumentos);
        LDDocTabla savedDocTabla = lddDocTablaRepository.save(docTabla);
        return lddDocTablaMapper.toDTO(savedDocTabla);
    }

    @Override
    public LDDocTablaDTO update(Long id, LDDocTablaDTO lddDocTablaDTO) {
        LDDocTabla existingDocTabla = lddDocTablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));

        existingDocTabla.setNombreReceptor(lddDocTablaDTO.getNombreReceptor());
        existingDocTabla.setPuesto(lddDocTablaDTO.getPuesto());
        existingDocTabla.setFirma(lddDocTablaDTO.getFirma());

        LDDocTabla updatedDocTabla = lddDocTablaRepository.save(existingDocTabla);
        return lddDocTablaMapper.toDTO(updatedDocTabla);
    }

    @Override
    public void deleteById(Long id) {
        lddDocTablaRepository.deleteById(id);
    }
}

