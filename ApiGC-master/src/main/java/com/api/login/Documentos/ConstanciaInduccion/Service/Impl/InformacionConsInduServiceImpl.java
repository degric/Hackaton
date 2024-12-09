package com.api.login.Documentos.ConstanciaInduccion.Service.Impl;

import com.api.login.Documentos.ConstanciaInduccion.DTO.InformacionConsInduDTO;
import com.api.login.Documentos.ConstanciaInduccion.Mapper.InformacionConsInduMapper;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.InformacionConsIndu;
import com.api.login.Documentos.ConstanciaInduccion.Repository.ConstanciaInduccionRepository;
import com.api.login.Documentos.ConstanciaInduccion.Repository.InformacionConsInduRepository;
import com.api.login.Documentos.ConstanciaInduccion.Service.InformacionConsInduService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformacionConsInduServiceImpl implements InformacionConsInduService {

    @Autowired
    private InformacionConsInduRepository repository;

    @Autowired
    private ConstanciaInduccionRepository constanciaRepository;

    @Autowired
    private InformacionConsInduMapper mapper;

    @Override
    public List<InformacionConsInduDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InformacionConsInduDTO findById(Long id) {
        InformacionConsIndu entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("InformacionConsIndu no encontrada"));
        return mapper.toDTO(entity);
    }

    @Override
    public List<InformacionConsInduDTO> findByConstanciaInduccionId(Long idConstanciaInduccion) {
        return repository.findByConstanciaInduccion_IdConstanciaInduccion(idConstanciaInduccion).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InformacionConsInduDTO save(InformacionConsInduDTO dto) {
        ConstanciaInduccion constancia = constanciaRepository.findById(dto.getIdConstanciaInduccion())
                .orElseThrow(() -> new EntityNotFoundException("ConstanciaInduccion no encontrada"));

        InformacionConsIndu entity = mapper.toEntity(dto, constancia);
        InformacionConsIndu savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public InformacionConsInduDTO update(Long id, InformacionConsInduDTO dto) {
        InformacionConsIndu existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("InformacionConsIndu no encontrada"));

        existingEntity.setInfo(dto.getInfo());
        existingEntity.setRespuesta(dto.getRespuesta());

        InformacionConsIndu updatedEntity = repository.save(existingEntity);
        return mapper.toDTO(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
