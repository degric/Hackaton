package com.api.login.Documentos.ConstanciaInduccion.Service.Impl;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradoresConsInduDTO;
import com.api.login.Documentos.ConstanciaInduccion.Mapper.ColaboradoresConsInduMapper;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ColaboradoresConsIndu;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import com.api.login.Documentos.ConstanciaInduccion.Repository.ColaboradoresConsInduRepository;
import com.api.login.Documentos.ConstanciaInduccion.Repository.ConstanciaInduccionRepository;
import com.api.login.Documentos.ConstanciaInduccion.Service.ColaboradoresConsInduService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColaboradoresConsInduServiceImpl implements ColaboradoresConsInduService {

    @Autowired
    private ColaboradoresConsInduRepository repository;

    @Autowired
    private ConstanciaInduccionRepository constanciaRepository;

    @Autowired
    private ColaboradoresConsInduMapper mapper;

    @Override
    public List<ColaboradoresConsInduDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ColaboradoresConsInduDTO findById(Long id) {
        ColaboradoresConsIndu entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ColaboradoresConsIndu no encontrado"));
        return mapper.toDTO(entity);
    }

    @Override
    public List<ColaboradoresConsInduDTO> findByConstanciaInduccionId(Long idConstanciaInduccion) {
        return repository.findByConstanciaInduccion_IdConstanciaInduccion(idConstanciaInduccion).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ColaboradoresConsInduDTO save(ColaboradoresConsInduDTO dto) {
        ConstanciaInduccion constancia = constanciaRepository.findById(dto.getIdConstanciaInduccion())
                .orElseThrow(() -> new EntityNotFoundException("ConstanciaInduccion no encontrada"));

        ColaboradoresConsIndu entity = mapper.toEntity(dto, constancia);
        ColaboradoresConsIndu savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public ColaboradoresConsInduDTO update(Long id, ColaboradoresConsInduDTO dto) {
        ColaboradoresConsIndu existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ColaboradoresConsIndu no encontrado"));

        existingEntity.setNombre(dto.getNombre());
        existingEntity.setPuesto(dto.getPuesto());
        existingEntity.setFirma(dto.getFirma());

        ColaboradoresConsIndu updatedEntity = repository.save(existingEntity);
        return mapper.toDTO(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
