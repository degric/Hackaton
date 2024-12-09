package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_BDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.EntradasRevisiondireccion_BMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.EntradasRevisiondireccion_B;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.EntradasRevisiondireccion_BRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.EntradasRevisiondireccion_BService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradasRevisiondireccion_BServiceImpl implements EntradasRevisiondireccion_BService {

    @Autowired
    private EntradasRevisiondireccion_BRepository entradasRevisiondireccion_BRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private EntradasRevisiondireccion_BMapper entradasRevisiondireccion_BMapper;

    @Override
    public List<EntradasRevisiondireccion_BDTO> findAll() {
        return entradasRevisiondireccion_BRepository.findAll().stream()
                .map(entradasRevisiondireccion_BMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EntradasRevisiondireccion_BDTO findById(Long id) {
        EntradasRevisiondireccion_B entrada = entradasRevisiondireccion_BRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrada no encontrada"));
        return entradasRevisiondireccion_BMapper.toDTO(entrada);
    }

    @Override
    public List<EntradasRevisiondireccion_BDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<EntradasRevisiondireccion_B> entradas = entradasRevisiondireccion_BRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return entradas.stream()
                .map(entradasRevisiondireccion_BMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EntradasRevisiondireccion_BDTO save(EntradasRevisiondireccion_BDTO entradasRevisiondireccion_BDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(entradasRevisiondireccion_BDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        EntradasRevisiondireccion_B entrada = entradasRevisiondireccion_BMapper.toEntity(entradasRevisiondireccion_BDTO, informeRevisionDireccion);
        EntradasRevisiondireccion_B savedEntrada = entradasRevisiondireccion_BRepository.save(entrada);
        return entradasRevisiondireccion_BMapper.toDTO(savedEntrada);
    }

    @Override
    public EntradasRevisiondireccion_BDTO update(Long id, EntradasRevisiondireccion_BDTO entradasRevisiondireccion_BDTO) {
        EntradasRevisiondireccion_B existingEntrada = entradasRevisiondireccion_BRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrada no encontrada"));

        existingEntrada.setSituacionActual(entradasRevisiondireccion_BDTO.getSituacionActual());

        EntradasRevisiondireccion_B updatedEntrada = entradasRevisiondireccion_BRepository.save(existingEntrada);
        return entradasRevisiondireccion_BMapper.toDTO(updatedEntrada);
    }

    @Override
    public void deleteById(Long id) {
        entradasRevisiondireccion_BRepository.deleteById(id);
    }
}
