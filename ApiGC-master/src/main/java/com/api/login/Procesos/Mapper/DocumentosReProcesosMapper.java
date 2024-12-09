package com.api.login.Procesos.Mapper;

import com.api.login.ManualDeCalidad.DTO.DocumentosReManualCalidadDTO;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.Dao.ManualCalidadDao;
import com.api.login.ManualDeCalidad.pojo.DocumentosReManualCalidad;
import com.api.login.Procesos.DTO.DocumentosReProcesosDTO;
import com.api.login.Procesos.Dao.EnProcesoDao;
import com.api.login.Procesos.Pojo.DocumentosReProcesos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentosReProcesosMapper {

    @Autowired
    private MachoteDocumentosDao machoteDocumentosRepository;

    @Autowired
    private EnProcesoDao enProcesoDao;

    public DocumentosReProcesosDTO toDTO(DocumentosReProcesos entity) {
        DocumentosReProcesosDTO dto = new DocumentosReProcesosDTO();
        dto.setIdDocumentosReProcesos(entity.getIdDocumentosReProcesos());
        dto.setNombrePunto(entity.getNombrePunto());
        dto.setNivelPunto(entity.getNivelPunto());
        dto.setIdSubpunto(entity.getIdSubpunto());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());
        dto.setIdMachoteDocumentos(entity.getMachoteDocumentos().getIdMachoteDocumentos());
        return dto;
    }

    public DocumentosReProcesos toEntity(DocumentosReProcesosDTO dto) {

        DocumentosReProcesos entity = new DocumentosReProcesos();
        entity.setIdDocumentosReProcesos(dto.getIdDocumentosReProcesos());
        entity.setNombrePunto(dto.getNombrePunto());
        entity.setNivelPunto(dto.getNivelPunto());
        entity.setIdSubpunto(dto.getIdSubpunto());

        entity.setEnProceso(enProcesoDao.findById(dto.getIdEnProceso())
                .orElseThrow(() -> new RuntimeException("Proceso not found")));

        entity.setMachoteDocumentos(machoteDocumentosRepository.findById(dto.getIdMachoteDocumentos())
                .orElseThrow(() -> new RuntimeException("MachoteDocumentos not found")));

        return entity;
    }
}


