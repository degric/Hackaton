package com.api.login.Documentos.MejoraContinua.Service.Impl;

import com.api.login.Documentos.MejoraContinua.DTO.IntegrantesMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Mapper.IntegrantesMejoraContinuaMapper;
import com.api.login.Documentos.MejoraContinua.Pojo.IntegrantesMejoraContinua;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import com.api.login.Documentos.MejoraContinua.Repository.IntegrantesMejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Repository.MejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Service.IntegrantesMejoraContinuaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntegrantesMejoraContinuaServiceImpl implements IntegrantesMejoraContinuaService {

    @Autowired
    private IntegrantesMejoraContinuaRepository integrantesRepository;

    @Autowired
    private MejoraContinuaRepository mejoraRepository;

    @Autowired
    private IntegrantesMejoraContinuaMapper integrantesMapper;

    @Override
    public List<IntegrantesMejoraContinuaDTO> findAll() {
        return integrantesRepository.findAll().stream()
                .map(integrantesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IntegrantesMejoraContinuaDTO findById(Long id) {
        IntegrantesMejoraContinua integrante = integrantesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Integrante de Mejora Continua no encontrado"));
        return integrantesMapper.toDTO(integrante);
    }

    @Override
    public List<IntegrantesMejoraContinuaDTO> findByMejoraContinua(Long idMejoraContinua) {
        List<IntegrantesMejoraContinua> integrantes = integrantesRepository.findByMejoraContinua_IdMejoraContinua(idMejoraContinua);
        return integrantes.stream()
                .map(integrantesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IntegrantesMejoraContinuaDTO save(IntegrantesMejoraContinuaDTO integranteDTO) {
        MejoraContinua mejoraContinua = mejoraRepository.findById(integranteDTO.getIdMejoraContinua())
                .orElseThrow(() -> new EntityNotFoundException("Mejora Continua no encontrada"));

        IntegrantesMejoraContinua integrante = integrantesMapper.toEntity(integranteDTO, mejoraContinua);
        IntegrantesMejoraContinua savedIntegrante = integrantesRepository.save(integrante);
        return integrantesMapper.toDTO(savedIntegrante);
    }

    @Override
    public IntegrantesMejoraContinuaDTO update(Long id, IntegrantesMejoraContinuaDTO integranteDTO) {
        IntegrantesMejoraContinua existingIntegrante = integrantesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Integrante de Mejora Continua no encontrado"));

        existingIntegrante.setIntegrante(integranteDTO.getIntegrante());
        existingIntegrante.setPuesto(integranteDTO.getPuesto());
        existingIntegrante.setFirma(integranteDTO.getFirma());

        IntegrantesMejoraContinua updatedIntegrante = integrantesRepository.save(existingIntegrante);
        return integrantesMapper.toDTO(updatedIntegrante);
    }

    @Override
    public void deleteById(Long id) {
        integrantesRepository.deleteById(id);
    }
}
