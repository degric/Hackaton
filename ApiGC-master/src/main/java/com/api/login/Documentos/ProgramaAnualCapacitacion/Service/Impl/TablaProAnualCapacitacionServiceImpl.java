package com.api.login.Documentos.ProgramaAnualCapacitacion.Service.Impl;

import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.TablaProAnualCapacitacionDTO;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Mapper.TablaProAnualCapacitacionMapper;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.ProAnualCapacitacion;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.TablaProAnualCapacitacion;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Repository.ProAnualCapacitacionRepository;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Repository.TablaProAnualCapacitacionRepository;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Service.TablaProAnualCapacitacionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TablaProAnualCapacitacionServiceImpl implements TablaProAnualCapacitacionService {

    @Autowired
    private TablaProAnualCapacitacionRepository repository;

    @Autowired
    private ProAnualCapacitacionRepository proAnualRepository;

    @Autowired
    private TablaProAnualCapacitacionMapper mapper;

    @Override
    public List<TablaProAnualCapacitacionDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaProAnualCapacitacionDTO findById(Long id) {
        TablaProAnualCapacitacion entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TablaProAnualCapacitacion no encontrada"));
        return mapper.toDTO(entity);
    }

    @Override
    public List<TablaProAnualCapacitacionDTO> findByProAnualCapacitacionId(Long idProAnualCapacitacion) {
        return repository.findByProAnualCapacitacion_IdProAnualCapacitacion(idProAnualCapacitacion).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaProAnualCapacitacionDTO save(TablaProAnualCapacitacionDTO dto) {
        ProAnualCapacitacion proAnual = proAnualRepository.findById(dto.getIdProAnualCapacitacion())
                .orElseThrow(() -> new EntityNotFoundException("ProAnualCapacitacion no encontrada"));

        TablaProAnualCapacitacion entity = mapper.toEntity(dto, proAnual);
        TablaProAnualCapacitacion savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public TablaProAnualCapacitacionDTO update(Long id, TablaProAnualCapacitacionDTO dto) {
        TablaProAnualCapacitacion existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TablaProAnualCapacitacion no encontrada"));

        existingEntity.setTitulo(dto.getTitulo());
        existingEntity.setPerDepartamento(dto.getPerDepartamento());
        existingEntity.setTipo(dto.getTipo());
        existingEntity.setCapacitador(dto.getCapacitador());
        existingEntity.setDuracion(dto.getDuracion());
        existingEntity.setEstatus(dto.getEstatus());
        existingEntity.setFecha(dto.getFecha());

        TablaProAnualCapacitacion updatedEntity = repository.save(existingEntity);
        return mapper.toDTO(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
