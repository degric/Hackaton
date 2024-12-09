package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDProcesosConformidadServiciosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.IRDProcesosConformidadServiciosMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDProcesosConformidadServicios;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.IRDProcesosConformidadServiciosRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDProcesosConformidadServiciosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRDProcesosConformidadServiciosServiceImpl implements IRDProcesosConformidadServiciosService {

    @Autowired
    private IRDProcesosConformidadServiciosRepository irdProcesosConformidadServiciosRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private IRDProcesosConformidadServiciosMapper irdProcesosConformidadServiciosMapper;

    @Override
    public List<IRDProcesosConformidadServiciosDTO> findAll() {
        return irdProcesosConformidadServiciosRepository.findAll().stream()
                .map(irdProcesosConformidadServiciosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDProcesosConformidadServiciosDTO findById(Long id) {
        IRDProcesosConformidadServicios proceso = irdProcesosConformidadServiciosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proceso no encontrado"));
        return irdProcesosConformidadServiciosMapper.toDTO(proceso);
    }

    @Override
    public List<IRDProcesosConformidadServiciosDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<IRDProcesosConformidadServicios> procesos = irdProcesosConformidadServiciosRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return procesos.stream()
                .map(irdProcesosConformidadServiciosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDProcesosConformidadServiciosDTO save(IRDProcesosConformidadServiciosDTO irdProcesosConformidadServiciosDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(irdProcesosConformidadServiciosDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        IRDProcesosConformidadServicios proceso = irdProcesosConformidadServiciosMapper.toEntity(irdProcesosConformidadServiciosDTO, informeRevisionDireccion);
        IRDProcesosConformidadServicios savedProceso = irdProcesosConformidadServiciosRepository.save(proceso);
        return irdProcesosConformidadServiciosMapper.toDTO(savedProceso);
    }

    @Override
    public IRDProcesosConformidadServiciosDTO update(Long id, IRDProcesosConformidadServiciosDTO irdProcesosConformidadServiciosDTO) {
        IRDProcesosConformidadServicios existingProceso = irdProcesosConformidadServiciosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proceso no encontrado"));

        existingProceso.setProceso(irdProcesosConformidadServiciosDTO.getProceso());
        existingProceso.setIndicador(irdProcesosConformidadServiciosDTO.getIndicador());
        existingProceso.setMeta(irdProcesosConformidadServiciosDTO.getMeta());
        existingProceso.setTendencia(irdProcesosConformidadServiciosDTO.getTendencia());
        existingProceso.setStatus(irdProcesosConformidadServiciosDTO.getStatus());

        IRDProcesosConformidadServicios updatedProceso = irdProcesosConformidadServiciosRepository.save(existingProceso);
        return irdProcesosConformidadServiciosMapper.toDTO(updatedProceso);
    }

    @Override
    public void deleteById(Long id) {
        irdProcesosConformidadServiciosRepository.deleteById(id);
    }
}

