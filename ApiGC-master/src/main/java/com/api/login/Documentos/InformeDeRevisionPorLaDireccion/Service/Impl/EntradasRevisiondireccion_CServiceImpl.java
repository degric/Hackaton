package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_CDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.EntradasRevisiondireccion_CMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.EntradasRevisiondireccion_C;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.EntradasRevisiondireccion_CRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.EntradasRevisiondireccion_CService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradasRevisiondireccion_CServiceImpl implements EntradasRevisiondireccion_CService {

    @Autowired
    private EntradasRevisiondireccion_CRepository entradasRevisiondireccion_CRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private EntradasRevisiondireccion_CMapper entradasRevisiondireccion_CMapper;

    @Override
    public List<EntradasRevisiondireccion_CDTO> findAll() {
        return entradasRevisiondireccion_CRepository.findAll().stream()
                .map(entradasRevisiondireccion_CMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EntradasRevisiondireccion_CDTO findById(Long id) {
        EntradasRevisiondireccion_C entrada = entradasRevisiondireccion_CRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrada no encontrada"));
        return entradasRevisiondireccion_CMapper.toDTO(entrada);
    }

    @Override
    public List<EntradasRevisiondireccion_CDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<EntradasRevisiondireccion_C> entradas = entradasRevisiondireccion_CRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return entradas.stream()
                .map(entradasRevisiondireccion_CMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EntradasRevisiondireccion_CDTO save(EntradasRevisiondireccion_CDTO entradasRevisiondireccion_CDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(entradasRevisiondireccion_CDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        EntradasRevisiondireccion_C entrada = entradasRevisiondireccion_CMapper.toEntity(entradasRevisiondireccion_CDTO, informeRevisionDireccion);
        EntradasRevisiondireccion_C savedEntrada = entradasRevisiondireccion_CRepository.save(entrada);
        return entradasRevisiondireccion_CMapper.toDTO(savedEntrada);
    }

    @Override
    public EntradasRevisiondireccion_CDTO update(Long id, EntradasRevisiondireccion_CDTO entradasRevisiondireccion_CDTO) {
        EntradasRevisiondireccion_C existingEntrada = entradasRevisiondireccion_CRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrada no encontrada"));

        existingEntrada.setSituacionActual(entradasRevisiondireccion_CDTO.getSituacionActual());
        existingEntrada.setRetroalimentacion(entradasRevisiondireccion_CDTO.getRetroalimentacion());

        EntradasRevisiondireccion_C updatedEntrada = entradasRevisiondireccion_CRepository.save(existingEntrada);
        return entradasRevisiondireccion_CMapper.toDTO(updatedEntrada);
    }

    @Override
    public void deleteById(Long id) {
        entradasRevisiondireccion_CRepository.deleteById(id);
    }
}

