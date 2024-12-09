package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDResultadosSeguimientoMedicionDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.IRDResultadosSeguimientoMedicionMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDResultadosSeguimientoMedicion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.IRDResultadosSeguimientoMedicionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDResultadosSeguimientoMedicionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRDResultadosSeguimientoMedicionServiceImpl implements IRDResultadosSeguimientoMedicionService {

    @Autowired
    private IRDResultadosSeguimientoMedicionRepository irdResultadosSeguimientoMedicionRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private IRDResultadosSeguimientoMedicionMapper irdResultadosSeguimientoMedicionMapper;

    @Override
    public List<IRDResultadosSeguimientoMedicionDTO> findAll() {
        return irdResultadosSeguimientoMedicionRepository.findAll().stream()
                .map(irdResultadosSeguimientoMedicionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDResultadosSeguimientoMedicionDTO findById(Long id) {
        IRDResultadosSeguimientoMedicion resultado = irdResultadosSeguimientoMedicionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resultado de seguimiento no encontrado"));
        return irdResultadosSeguimientoMedicionMapper.toDTO(resultado);
    }

    @Override
    public List<IRDResultadosSeguimientoMedicionDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<IRDResultadosSeguimientoMedicion> resultados = irdResultadosSeguimientoMedicionRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return resultados.stream()
                .map(irdResultadosSeguimientoMedicionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDResultadosSeguimientoMedicionDTO save(IRDResultadosSeguimientoMedicionDTO irdResultadosSeguimientoMedicionDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(irdResultadosSeguimientoMedicionDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        IRDResultadosSeguimientoMedicion resultado = irdResultadosSeguimientoMedicionMapper.toEntity(irdResultadosSeguimientoMedicionDTO, informeRevisionDireccion);
        IRDResultadosSeguimientoMedicion savedResultado = irdResultadosSeguimientoMedicionRepository.save(resultado);
        return irdResultadosSeguimientoMedicionMapper.toDTO(savedResultado);
    }

    @Override
    public IRDResultadosSeguimientoMedicionDTO update(Long id, IRDResultadosSeguimientoMedicionDTO irdResultadosSeguimientoMedicionDTO) {
        IRDResultadosSeguimientoMedicion existingResultado = irdResultadosSeguimientoMedicionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resultado de seguimiento no encontrado"));

        existingResultado.setContenido(irdResultadosSeguimientoMedicionDTO.getContenido());

        IRDResultadosSeguimientoMedicion updatedResultado = irdResultadosSeguimientoMedicionRepository.save(existingResultado);
        return irdResultadosSeguimientoMedicionMapper.toDTO(updatedResultado);
    }

    @Override
    public void deleteById(Long id) {
        irdResultadosSeguimientoMedicionRepository.deleteById(id);
    }
}

