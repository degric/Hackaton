package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.InformeRevisionDireccionEntradaDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.InformeRevisionDireccionEntradaMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccionEntrada;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionEntradaRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.InformeRevisionDireccionEntradaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformeRevisionDireccionEntradaServiceImpl implements InformeRevisionDireccionEntradaService {

    @Autowired
    private InformeRevisionDireccionEntradaRepository informeRevisionDireccionEntradaRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private InformeRevisionDireccionEntradaMapper informeRevisionDireccionEntradaMapper;

    @Override
    public List<InformeRevisionDireccionEntradaDTO> findAll() {
        return informeRevisionDireccionEntradaRepository.findAll().stream()
                .map(informeRevisionDireccionEntradaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InformeRevisionDireccionEntradaDTO findById(Long id) {
        InformeRevisionDireccionEntrada entrada = informeRevisionDireccionEntradaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrada no encontrada"));
        return informeRevisionDireccionEntradaMapper.toDTO(entrada);
    }

    @Override
    public List<InformeRevisionDireccionEntradaDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<InformeRevisionDireccionEntrada> entradas = informeRevisionDireccionEntradaRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return entradas.stream()
                .map(informeRevisionDireccionEntradaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InformeRevisionDireccionEntradaDTO save(InformeRevisionDireccionEntradaDTO informeRevisionDireccionEntradaDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(informeRevisionDireccionEntradaDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        InformeRevisionDireccionEntrada entrada = informeRevisionDireccionEntradaMapper.toEntity(informeRevisionDireccionEntradaDTO, informeRevisionDireccion);
        InformeRevisionDireccionEntrada savedEntrada = informeRevisionDireccionEntradaRepository.save(entrada);
        return informeRevisionDireccionEntradaMapper.toDTO(savedEntrada);
    }

    @Override
    public InformeRevisionDireccionEntradaDTO update(Long id, InformeRevisionDireccionEntradaDTO informeRevisionDireccionEntradaDTO) {
        InformeRevisionDireccionEntrada existingEntrada = informeRevisionDireccionEntradaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrada no encontrada"));

        existingEntrada.setEntradas(informeRevisionDireccionEntradaDTO.getEntradas());
        existingEntrada.setDirectrices(informeRevisionDireccionEntradaDTO.getDirectrices());

        InformeRevisionDireccionEntrada updatedEntrada = informeRevisionDireccionEntradaRepository.save(existingEntrada);
        return informeRevisionDireccionEntradaMapper.toDTO(updatedEntrada);
    }

    @Override
    public void deleteById(Long id) {
        informeRevisionDireccionEntradaRepository.deleteById(id);
    }
}

