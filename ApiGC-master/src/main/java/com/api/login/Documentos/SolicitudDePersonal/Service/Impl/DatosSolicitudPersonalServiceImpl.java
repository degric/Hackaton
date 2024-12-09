package com.api.login.Documentos.SolicitudDePersonal.Service.Impl;

import com.api.login.Documentos.SolicitudDePersonal.DTO.DatosSolicitudPersonalDTO;
import com.api.login.Documentos.SolicitudDePersonal.Mapper.DatosSolicitudPersonalMapper;
import com.api.login.Documentos.SolicitudDePersonal.Pojo.DatosSolicitudPersonal;
import com.api.login.Documentos.SolicitudDePersonal.Pojo.SolicitudPersonal;
import com.api.login.Documentos.SolicitudDePersonal.Repository.DatosSolicitudPersonalRepository;
import com.api.login.Documentos.SolicitudDePersonal.Repository.SolicitudPersonalRepository;
import com.api.login.Documentos.SolicitudDePersonal.Service.DatosSolicitudPersonalService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatosSolicitudPersonalServiceImpl implements DatosSolicitudPersonalService {

    @Autowired
    private DatosSolicitudPersonalRepository datosRepository;

    @Autowired
    private SolicitudPersonalRepository solicitudRepository;

    @Autowired
    private DatosSolicitudPersonalMapper datosMapper;

    @Override
    public List<DatosSolicitudPersonalDTO> findAll() {
        return datosRepository.findAll().stream()
                .map(datosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DatosSolicitudPersonalDTO findById(Long id) {
        DatosSolicitudPersonal datos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Solicitud Personal no encontrados"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosSolicitudPersonalDTO findBySolicitudPersonal(Long idSolicitudPersonal) {
        DatosSolicitudPersonal datos = datosRepository.findBySolicitudPersonal_IdSolicitudPersonal(idSolicitudPersonal)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Solicitud Personal no encontrados para la Solicitud especificada"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosSolicitudPersonalDTO save(DatosSolicitudPersonalDTO datosSolicitudPersonalDTO) {
        SolicitudPersonal solicitudPersonal = solicitudRepository.findById(datosSolicitudPersonalDTO.getIdSolicitudPersonal())
                .orElseThrow(() -> new EntityNotFoundException("Solicitud Personal no encontrada"));

        DatosSolicitudPersonal datos = datosMapper.toEntity(datosSolicitudPersonalDTO, solicitudPersonal);
        DatosSolicitudPersonal savedDatos = datosRepository.save(datos);
        return datosMapper.toDTO(savedDatos);
    }

    @Override
    public DatosSolicitudPersonalDTO update(Long id, DatosSolicitudPersonalDTO datosSolicitudPersonalDTO) {
        DatosSolicitudPersonal existingDatos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Solicitud Personal no encontrados"));

        existingDatos.setNombre(datosSolicitudPersonalDTO.getNombre());
        existingDatos.setCargo(datosSolicitudPersonalDTO.getCargo());
        existingDatos.setAreaActual(datosSolicitudPersonalDTO.getAreaActual());
        existingDatos.setFechaSolicitud(datosSolicitudPersonalDTO.getFechaSolicitud());
        existingDatos.setPuestoSolicitado(datosSolicitudPersonalDTO.getPuestoSolicitado());
        existingDatos.setAreaNueva(datosSolicitudPersonalDTO.getAreaNueva());
        existingDatos.setNumeroVacantes(datosSolicitudPersonalDTO.getNumeroVacantes());
        existingDatos.setFechaPrevista(datosSolicitudPersonalDTO.getFechaPrevista());
        existingDatos.setMotivotipoContrato(datosSolicitudPersonalDTO.getMotivotipoContrato());
        existingDatos.setEstatus(datosSolicitudPersonalDTO.getEstatus());
        existingDatos.setEspecifique(datosSolicitudPersonalDTO.getEspecifique());

        DatosSolicitudPersonal updatedDatos = datosRepository.save(existingDatos);
        return datosMapper.toDTO(updatedDatos);
    }

    @Override
    public void deleteById(Long id) {
        datosRepository.deleteById(id);
    }
}
