package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDAdecuacionRecursosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.IRDAdecuacionRecursosMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDAdecuacionRecursos;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.IRDAdecuacionRecursosRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDAdecuacionRecursosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRDAdecuacionRecursosServiceImpl implements IRDAdecuacionRecursosService {

    @Autowired
    private IRDAdecuacionRecursosRepository irdAdecuacionRecursosRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private IRDAdecuacionRecursosMapper irdAdecuacionRecursosMapper;

    @Override
    public List<IRDAdecuacionRecursosDTO> findAll() {
        return irdAdecuacionRecursosRepository.findAll().stream()
                .map(irdAdecuacionRecursosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDAdecuacionRecursosDTO findById(Long id) {
        IRDAdecuacionRecursos resultado = irdAdecuacionRecursosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Adecuación de recursos no encontrada"));
        return irdAdecuacionRecursosMapper.toDTO(resultado);
    }

    @Override
    public List<IRDAdecuacionRecursosDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<IRDAdecuacionRecursos> recursos = irdAdecuacionRecursosRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return recursos.stream()
                .map(irdAdecuacionRecursosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDAdecuacionRecursosDTO save(IRDAdecuacionRecursosDTO irdAdecuacionRecursosDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(irdAdecuacionRecursosDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        IRDAdecuacionRecursos recurso = irdAdecuacionRecursosMapper.toEntity(irdAdecuacionRecursosDTO, informeRevisionDireccion);
        IRDAdecuacionRecursos savedRecurso = irdAdecuacionRecursosRepository.save(recurso);
        return irdAdecuacionRecursosMapper.toDTO(savedRecurso);
    }

    @Override
    public IRDAdecuacionRecursosDTO update(Long id, IRDAdecuacionRecursosDTO irdAdecuacionRecursosDTO) {
        IRDAdecuacionRecursos existingRecurso = irdAdecuacionRecursosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Adecuación de recursos no encontrada"));

        existingRecurso.setSituacionActual(irdAdecuacionRecursosDTO.getSituacionActual());

        IRDAdecuacionRecursos updatedRecurso = irdAdecuacionRecursosRepository.save(existingRecurso);
        return irdAdecuacionRecursosMapper.toDTO(updatedRecurso);
    }

    @Override
    public void deleteById(Long id) {
        irdAdecuacionRecursosRepository.deleteById(id);
    }
}

