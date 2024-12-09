package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDObjetivosCalidadDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.IRDObjetivosCalidadMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDObjetivosCalidad;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.IRDObjetivosCalidadRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDObjetivosCalidadService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRDObjetivosCalidadServiceImpl implements IRDObjetivosCalidadService {

    @Autowired
    private IRDObjetivosCalidadRepository irdObjetivosCalidadRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private IRDObjetivosCalidadMapper irdObjetivosCalidadMapper;

    @Override
    public List<IRDObjetivosCalidadDTO> findAll() {
        return irdObjetivosCalidadRepository.findAll().stream()
                .map(irdObjetivosCalidadMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDObjetivosCalidadDTO findById(Long id) {
        IRDObjetivosCalidad objetivo = irdObjetivosCalidadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Objetivo de calidad no encontrado"));
        return irdObjetivosCalidadMapper.toDTO(objetivo);
    }

    @Override
    public List<IRDObjetivosCalidadDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<IRDObjetivosCalidad> objetivos = irdObjetivosCalidadRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return objetivos.stream()
                .map(irdObjetivosCalidadMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDObjetivosCalidadDTO save(IRDObjetivosCalidadDTO irdObjetivosCalidadDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(irdObjetivosCalidadDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        IRDObjetivosCalidad objetivo = irdObjetivosCalidadMapper.toEntity(irdObjetivosCalidadDTO, informeRevisionDireccion);
        IRDObjetivosCalidad savedObjetivo = irdObjetivosCalidadRepository.save(objetivo);
        return irdObjetivosCalidadMapper.toDTO(savedObjetivo);
    }

    @Override
    public IRDObjetivosCalidadDTO update(Long id, IRDObjetivosCalidadDTO irdObjetivosCalidadDTO) {
        IRDObjetivosCalidad existingObjetivo = irdObjetivosCalidadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Objetivo de calidad no encontrado"));

        existingObjetivo.setContenido(irdObjetivosCalidadDTO.getContenido());

        IRDObjetivosCalidad updatedObjetivo = irdObjetivosCalidadRepository.save(existingObjetivo);
        return irdObjetivosCalidadMapper.toDTO(updatedObjetivo);
    }

    @Override
    public void deleteById(Long id) {
        irdObjetivosCalidadRepository.deleteById(id);
    }
}
