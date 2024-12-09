package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.InformeRevisionDireccionDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.InformeRevisionDireccionMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.InformeRevisionDireccionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformeRevisionDireccionServiceImpl implements InformeRevisionDireccionService {

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    @Override
    public List<InformeRevisionDireccionDTO> findAll() {
        return informeRevisionDireccionRepository.findAll().stream()
                .map(informeRevisionDireccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InformeRevisionDireccionDTO findById(Long id) {
        InformeRevisionDireccion informe = informeRevisionDireccionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));
        return informeRevisionDireccionMapper.toDTO(informe);
    }

    @Override
    public InformeRevisionDireccionDTO save(InformeRevisionDireccionDTO informeRevisionDireccionDTO) {
        InformeRevisionDireccion informe = informeRevisionDireccionMapper.toEntity(informeRevisionDireccionDTO);
        InformeRevisionDireccion savedInforme = informeRevisionDireccionRepository.save(informe);
        return informeRevisionDireccionMapper.toDTO(savedInforme);
    }

    @Override
    public InformeRevisionDireccionDTO update(Long id, InformeRevisionDireccionDTO informeRevisionDireccionDTO) {
        InformeRevisionDireccion existingInforme = informeRevisionDireccionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        existingInforme.setCoDocumento(informeRevisionDireccionDTO.getCoDocumento());
        existingInforme.setNoRevision(informeRevisionDireccionDTO.getNoRevision());
        existingInforme.setFechaEmicion(informeRevisionDireccionDTO.getFechaEmicion());
        existingInforme.setFechaRevision(informeRevisionDireccionDTO.getFechaRevision());

        InformeRevisionDireccion updatedInforme = informeRevisionDireccionRepository.save(existingInforme);
        return informeRevisionDireccionMapper.toDTO(updatedInforme);
    }

    @Override
    public void deleteById(Long id) {
        informeRevisionDireccionRepository.deleteById(id);
    }
}
