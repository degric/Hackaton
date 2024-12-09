package com.api.login.ManualDeCalidad.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.api.login.ManualDeCalidad.DTO.DocumentosReManualCalidadDTO;
import com.api.login.ManualDeCalidad.Dao.DocumentosReManualCalidadDao;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.Dao.ManualCalidadDao;
import com.api.login.ManualDeCalidad.Mapper.DocumentosReManualCalidadMapper;
import com.api.login.ManualDeCalidad.Service.DocumentosReManualCalidadService;
import com.api.login.ManualDeCalidad.pojo.DocumentosReManualCalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocumentosReManualCalidadServiceImpl implements DocumentosReManualCalidadService {

    @Autowired
    private DocumentosReManualCalidadDao repository;

    @Autowired
    private DocumentosReManualCalidadMapper mapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosRepository;

    @Autowired
    private ManualCalidadDao manualCalidadRepository;

    @Override
    public DocumentosReManualCalidadDTO createDocumentosReManualCalidad(DocumentosReManualCalidadDTO dto) {
        DocumentosReManualCalidad entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public DocumentosReManualCalidadDTO getDocumentosReManualCalidadById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("DocumentosReManualCalidad not found"));
    }

    @Override
    public List<DocumentosReManualCalidadDTO> getAllDocumentosReManualCalidad() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentosReManualCalidadDTO updateDocumentosReManualCalidad(Long id, DocumentosReManualCalidadDTO dto) {
        DocumentosReManualCalidad entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DocumentosReManualCalidad not found"));

        entity.setNombrePunto(dto.getNombrePunto());
        entity.setIdSubpunto(dto.getIdSubpunto());

        entity.setManualCalidad(manualCalidadRepository.findById(dto.getIdManualCalidad())
                .orElseThrow(() -> new RuntimeException("ManualCalidad not found")));

        entity.setMachoteDocumentos(machoteDocumentosRepository.findById(dto.getIdMachoteDocumentos())
                .orElseThrow(() -> new RuntimeException("MachoteDocumentos not found")));

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void deleteDocumentosReManualCalidad(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DocumentosReManualCalidadDTO> getIdManual(Long idManual) {
        return repository.findByManualCalidadIdManualCalidad(idManual).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}


