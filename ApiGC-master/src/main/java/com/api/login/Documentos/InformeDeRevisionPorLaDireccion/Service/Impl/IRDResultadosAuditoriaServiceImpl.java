package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDResultadosAuditoriaDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.IRDResultadosAuditoriaMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDResultadosAuditoria;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.IRDResultadosAuditoriaRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDResultadosAuditoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRDResultadosAuditoriaServiceImpl implements IRDResultadosAuditoriaService {

    @Autowired
    private IRDResultadosAuditoriaRepository irdResultadosAuditoriaRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private IRDResultadosAuditoriaMapper irdResultadosAuditoriaMapper;

    @Override
    public List<IRDResultadosAuditoriaDTO> findAll() {
        return irdResultadosAuditoriaRepository.findAll().stream()
                .map(irdResultadosAuditoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDResultadosAuditoriaDTO findById(Long id) {
        IRDResultadosAuditoria resultado = irdResultadosAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resultado de auditoría no encontrado"));
        return irdResultadosAuditoriaMapper.toDTO(resultado);
    }

    @Override
    public List<IRDResultadosAuditoriaDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<IRDResultadosAuditoria> resultados = irdResultadosAuditoriaRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return resultados.stream()
                .map(irdResultadosAuditoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDResultadosAuditoriaDTO save(IRDResultadosAuditoriaDTO irdResultadosAuditoriaDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(irdResultadosAuditoriaDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        IRDResultadosAuditoria resultado = irdResultadosAuditoriaMapper.toEntity(irdResultadosAuditoriaDTO, informeRevisionDireccion);
        IRDResultadosAuditoria savedResultado = irdResultadosAuditoriaRepository.save(resultado);
        return irdResultadosAuditoriaMapper.toDTO(savedResultado);
    }

    @Override
    public IRDResultadosAuditoriaDTO update(Long id, IRDResultadosAuditoriaDTO irdResultadosAuditoriaDTO) {
        IRDResultadosAuditoria existingResultado = irdResultadosAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resultado de auditoría no encontrado"));

        existingResultado.setContenido(irdResultadosAuditoriaDTO.getContenido());

        IRDResultadosAuditoria updatedResultado = irdResultadosAuditoriaRepository.save(existingResultado);
        return irdResultadosAuditoriaMapper.toDTO(updatedResultado);
    }

    @Override
    public void deleteById(Long id) {
        irdResultadosAuditoriaRepository.deleteById(id);
    }
}
