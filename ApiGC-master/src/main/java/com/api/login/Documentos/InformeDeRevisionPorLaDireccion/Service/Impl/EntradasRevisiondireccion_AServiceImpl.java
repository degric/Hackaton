package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_ADTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.EntradasRevisiondireccion_AMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.EntradasRevisiondireccion_A;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.EntradasRevisiondireccion_ARepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.EntradasRevisiondireccion_AService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradasRevisiondireccion_AServiceImpl implements EntradasRevisiondireccion_AService {

    @Autowired
    private EntradasRevisiondireccion_ARepository entradasRevisiondireccion_ARepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private EntradasRevisiondireccion_AMapper entradasRevisiondireccion_AMapper;

    @Override
    public List<EntradasRevisiondireccion_ADTO> findAll() {
        return entradasRevisiondireccion_ARepository.findAll().stream()
                .map(entradasRevisiondireccion_AMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EntradasRevisiondireccion_ADTO findById(Long id) {
        EntradasRevisiondireccion_A entrada = entradasRevisiondireccion_ARepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Entrada no encontrada"));
        return entradasRevisiondireccion_AMapper.toDTO(entrada);
    }

    @Override
    public List<EntradasRevisiondireccion_ADTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<EntradasRevisiondireccion_A> entradas = entradasRevisiondireccion_ARepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return entradas.stream()
                .map(entradasRevisiondireccion_AMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EntradasRevisiondireccion_ADTO save(EntradasRevisiondireccion_ADTO entradasRevisiondireccion_ADTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(entradasRevisiondireccion_ADTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        EntradasRevisiondireccion_A entrada = entradasRevisiondireccion_AMapper.toEntity(entradasRevisiondireccion_ADTO, informeRevisionDireccion);
        EntradasRevisiondireccion_A savedEntrada = entradasRevisiondireccion_ARepository.save(entrada);
        return entradasRevisiondireccion_AMapper.toDTO(savedEntrada);
    }

    @Override
    public EntradasRevisiondireccion_ADTO update(Long id, EntradasRevisiondireccion_ADTO entradasRevisiondireccion_ADTO) {
        EntradasRevisiondireccion_A existingEntrada = entradasRevisiondireccion_ARepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrada no encontrada"));

        existingEntrada.setSituacionActual(entradasRevisiondireccion_ADTO.getSituacionActual());

        EntradasRevisiondireccion_A updatedEntrada = entradasRevisiondireccion_ARepository.save(existingEntrada);
        return entradasRevisiondireccion_AMapper.toDTO(updatedEntrada);
    }

    @Override
    public void deleteById(Long id) {
        entradasRevisiondireccion_ARepository.deleteById(id);
    }
}


