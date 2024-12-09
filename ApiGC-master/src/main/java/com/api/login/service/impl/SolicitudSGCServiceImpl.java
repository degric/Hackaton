package com.api.login.service.impl;

import com.api.login.DTO.SolicitudSGCDTO;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import com.api.login.dao.SolicitudSGCDao;
import com.api.login.mapper.SolicitudSGCMapper;
import com.api.login.pojo.SolicitudSGC;
import com.api.login.service.SolicitudSGCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolicitudSGCServiceImpl implements SolicitudSGCService {

    @Autowired
    private SolicitudSGCDao solicitudSGCDao;

    @Autowired
    private SolicitudSGCMapper mapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosDao;


    @Override
    public List<SolicitudSGCDTO> getAll() {
        List<SolicitudSGC> solicitudSGCS= solicitudSGCDao.findAll();
        return solicitudSGCS.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudSGCDTO create(SolicitudSGCDTO dto) {
        SolicitudSGC solicitudSGC = mapper.toEntity(dto);
        solicitudSGC = solicitudSGCDao.save(solicitudSGC);

        // Guardado en el machote de Manual de Calidad
        Optional<MachoteDocumentos> optional = machoteDocumentosDao.findByNombreDocumento("Solicitud de cambio al sistema de gestión de calidad");

        if (optional.isPresent()) {
            MachoteDocumentos existingMachoteDocumentos = optional.get();
            existingMachoteDocumentos.setIdDocumento(solicitudSGC.getIdSolicitudSGC().longValue());
            machoteDocumentosDao.save(existingMachoteDocumentos);
        } else {
            MachoteDocumentos newMachoteDocumentos = new MachoteDocumentos();
            newMachoteDocumentos.setNombreDocumento("Solicitud de cambio al sistema de gestión de calidad");
            newMachoteDocumentos.setIdDocumento(solicitudSGC.getIdSolicitudSGC().longValue());
            newMachoteDocumentos.setNivelDocumento(2);
            newMachoteDocumentos.setCodigoDocumento(solicitudSGC.getCoDocumento());

            machoteDocumentosDao.save(newMachoteDocumentos);
        }



        return mapper.toDTO(solicitudSGC);
    }

    @Override
    public SolicitudSGCDTO update(Integer id, SolicitudSGCDTO solicitudSGCDTO) {
        Optional<SolicitudSGC> optional = solicitudSGCDao.findById(id);
        if (optional.isPresent()){
            SolicitudSGC solicitudSGC = optional.get();
            solicitudSGC.setCoDocumento(solicitudSGCDTO.getCoDocumento());
            solicitudSGC.setNumeroRevision(solicitudSGCDTO.getNumeroRevision());
            solicitudSGC.setFechaEmision(solicitudSGCDTO.getFechaEmision());
            solicitudSGC.setFechaRevision(solicitudSGCDTO.getFechaRevision());
            solicitudSGC.setFecha(solicitudSGCDTO.getFecha());
            solicitudSGC.setDocumento(solicitudSGCDTO.getDocumento());
            solicitudSGC.setMotivoCambio(solicitudSGCDTO.getMotivoCambio());
            solicitudSGC.setPuntosAfectaran(solicitudSGCDTO.getPuntosAfectaran());
            solicitudSGC.setNuevaRevision(solicitudSGCDTO.getNuevaRevision());
            solicitudSGC.setFechaEdicion(solicitudSGCDTO.getFechaEdicion());
            solicitudSGC.setNuevaFechaEdicion(solicitudSGCDTO.getNuevaFechaEdicion());
            solicitudSGC.setObservaciones(solicitudSGCDTO.getObservaciones());
            solicitudSGC.setSolicita(solicitudSGCDTO.getSolicita());
            solicitudSGC.setAutoriza(solicitudSGCDTO.getAutoriza());

            solicitudSGC = solicitudSGCDao.save(solicitudSGC);
            return mapper.toDTO(solicitudSGC);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
    Optional<SolicitudSGC> optional = solicitudSGCDao.findById(id);
        if (optional.isPresent()){
            solicitudSGCDao.deleteById(id);
        }
    }
}
