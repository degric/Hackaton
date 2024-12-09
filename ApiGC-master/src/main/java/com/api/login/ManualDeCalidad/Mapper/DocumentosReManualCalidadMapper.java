package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.DocumentosReManualCalidadDTO;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.Dao.ManualCalidadDao;
import com.api.login.ManualDeCalidad.pojo.DocumentosReManualCalidad;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentosReManualCalidadMapper {

    @Autowired
    private MachoteDocumentosDao machoteDocumentosRepository;

    @Autowired
    private ManualCalidadDao manualCalidadRepository;

    public DocumentosReManualCalidadDTO toDTO(DocumentosReManualCalidad entity) {
        DocumentosReManualCalidadDTO dto = new DocumentosReManualCalidadDTO();
        dto.setIdDocumentosReManualCalidad(entity.getIdDocumentosReManualCalidad());
        dto.setNombrePunto(entity.getNombrePunto());
        dto.setIdSubpunto(entity.getIdSubpunto());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        dto.setIdMachoteDocumentos(entity.getMachoteDocumentos().getIdMachoteDocumentos());
        return dto;
    }

    public DocumentosReManualCalidad toEntity(DocumentosReManualCalidadDTO dto) {
        DocumentosReManualCalidad entity = new DocumentosReManualCalidad();
        entity.setIdDocumentosReManualCalidad(dto.getIdDocumentosReManualCalidad());
        entity.setNombrePunto(dto.getNombrePunto());
        entity.setIdSubpunto(dto.getIdSubpunto());

        entity.setManualCalidad(manualCalidadRepository.findById(dto.getIdManualCalidad())
                .orElseThrow(() -> new RuntimeException("ManualCalidad not found")));

        entity.setMachoteDocumentos(machoteDocumentosRepository.findById(dto.getIdMachoteDocumentos())
                .orElseThrow(() -> new RuntimeException("MachoteDocumentos not found")));

        return entity;
    }
}


