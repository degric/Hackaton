package com.api.login.Documentos.MejoraContinua.Service.Impl;

import com.api.login.Documentos.MejoraContinua.DTO.TablaMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Mapper.TablaMejoraContinuaMapper;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import com.api.login.Documentos.MejoraContinua.Pojo.TablaMejoraContinua;
import com.api.login.Documentos.MejoraContinua.Repository.MejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Repository.TablaMejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Service.TablaMejoraContinuaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TablaMejoraContinuaServiceImpl implements TablaMejoraContinuaService {

    @Autowired
    private TablaMejoraContinuaRepository tablaRepository;

    @Autowired
    private MejoraContinuaRepository mejoraRepository;

    @Autowired
    private TablaMejoraContinuaMapper tablaMapper;

    @Override
    public List<TablaMejoraContinuaDTO> findAll() {
        return tablaRepository.findAll().stream()
                .map(tablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaMejoraContinuaDTO findById(Long id) {
        TablaMejoraContinua tabla = tablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea de Mejora Continua no encontrada"));
        return tablaMapper.toDTO(tabla);
    }

    @Override
    public List<TablaMejoraContinuaDTO> findByMejoraContinua(Long idMejoraContinua) {
        List<TablaMejoraContinua> tablas = tablaRepository.findByMejoraContinua_IdMejoraContinua(idMejoraContinua);
        return tablas.stream()
                .map(tablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaMejoraContinuaDTO save(TablaMejoraContinuaDTO tablaDTO) {
        MejoraContinua mejoraContinua = mejoraRepository.findById(tablaDTO.getIdMejoraContinua())
                .orElseThrow(() -> new EntityNotFoundException("Mejora Continua no encontrada"));

        TablaMejoraContinua tabla = tablaMapper.toEntity(tablaDTO, mejoraContinua);
        TablaMejoraContinua savedTabla = tablaRepository.save(tabla);
        return tablaMapper.toDTO(savedTabla);
    }

    @Override
    public TablaMejoraContinuaDTO update(Long id, TablaMejoraContinuaDTO tablaDTO) {
        TablaMejoraContinua existingTabla = tablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea de Mejora Continua no encontrada"));

        existingTabla.setQueSeVaHacer(tablaDTO.getQueSeVaHacer());
        existingTabla.setMetaEsperada(tablaDTO.getMetaEsperada());

        TablaMejoraContinua updatedTabla = tablaRepository.save(existingTabla);
        return tablaMapper.toDTO(updatedTabla);
    }

    @Override
    public void deleteById(Long id) {
        tablaRepository.deleteById(id);
    }
}

