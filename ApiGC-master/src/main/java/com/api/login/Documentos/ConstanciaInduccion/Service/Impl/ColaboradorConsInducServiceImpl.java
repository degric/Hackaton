package com.api.login.Documentos.ConstanciaInduccion.Service.Impl;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradorConsInducDTO;
import com.api.login.Documentos.ConstanciaInduccion.Mapper.ColaboradorConsInducMapper;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ColaboradorConsInduc;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import com.api.login.Documentos.ConstanciaInduccion.Repository.ColaboradorConsInducRepository;
import com.api.login.Documentos.ConstanciaInduccion.Repository.ConstanciaInduccionRepository;
import com.api.login.Documentos.ConstanciaInduccion.Service.ColaboradorConsInducService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColaboradorConsInducServiceImpl implements ColaboradorConsInducService {

    @Autowired
    private ColaboradorConsInducRepository repository;

    @Autowired
    private ConstanciaInduccionRepository constanciaRepository;

    @Autowired
    private ColaboradorConsInducMapper mapper;

    @Override
    public List<ColaboradorConsInducDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ColaboradorConsInducDTO findById(Long id) {
        ColaboradorConsInduc entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ColaboradorConsInduc no encontrado"));
        return mapper.toDTO(entity);
    }

    @Override
    public ColaboradorConsInducDTO findByConstanciaInduccionId(Long idConstanciaInduccion) {
        ColaboradorConsInduc entity = repository.findByConstanciaInduccion_IdConstanciaInduccion(idConstanciaInduccion)
                .orElseThrow(() -> new EntityNotFoundException("ColaboradorConsInduc no encontrado para la ConstanciaInduccion"));
        return mapper.toDTO(entity);
    }

    @Override
    public ColaboradorConsInducDTO save(ColaboradorConsInducDTO dto) {
        ConstanciaInduccion constancia = constanciaRepository.findById(dto.getIdConstanciaInduccion())
                .orElseThrow(() -> new EntityNotFoundException("ConstanciaInduccion no encontrada"));

        ColaboradorConsInduc entity = mapper.toEntity(dto, constancia);
        ColaboradorConsInduc savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public ColaboradorConsInducDTO update(Long id, ColaboradorConsInducDTO dto) {
        ColaboradorConsInduc existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ColaboradorConsInduc no encontrado"));

        existingEntity.setNombre(dto.getNombre());
        existingEntity.setFirma(dto.getFirma());

        ColaboradorConsInduc updatedEntity = repository.save(existingEntity);
        return mapper.toDTO(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
