package com.api.login.Documentos.MejoraContinua.Service.Impl;

import com.api.login.Documentos.MejoraContinua.DTO.DatosMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Mapper.DatosMejoraContinuaMapper;
import com.api.login.Documentos.MejoraContinua.Pojo.DatosMejoraContinua;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import com.api.login.Documentos.MejoraContinua.Repository.DatosMejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Repository.MejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Service.DatosMejoraContinuaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatosMejoraContinuaServiceImpl implements DatosMejoraContinuaService {

    @Autowired
    private DatosMejoraContinuaRepository datosRepository;

    @Autowired
    private MejoraContinuaRepository mejoraRepository;

    @Autowired
    private DatosMejoraContinuaMapper datosMapper;

    @Override
    public List<DatosMejoraContinuaDTO> findAll() {
        return datosRepository.findAll().stream()
                .map(datosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DatosMejoraContinuaDTO findById(Long id) {
        DatosMejoraContinua datos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Mejora Continua no encontrados"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosMejoraContinuaDTO findByMejoraContinua(Long idMejoraContinua) {
        DatosMejoraContinua datos = datosRepository.findByMejoraContinua_IdMejoraContinua(idMejoraContinua)
                .orElseThrow(() -> new EntityNotFoundException("Datos no encontrados para la Mejora Continua especificada"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosMejoraContinuaDTO save(DatosMejoraContinuaDTO datosDTO) {
        MejoraContinua mejoraContinua = mejoraRepository
                .findById(datosDTO.getIdMejoraContinua())
                .orElseThrow(() -> new EntityNotFoundException("Mejora Continua no encontrada"));

        DatosMejoraContinua datos = datosMapper.toEntity(datosDTO, mejoraContinua);
        DatosMejoraContinua savedDatos = datosRepository.save(datos);
        return datosMapper.toDTO(savedDatos);
    }

    @Override
    public DatosMejoraContinuaDTO update(Long id, DatosMejoraContinuaDTO datosDTO) {
        DatosMejoraContinua existingDatos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Mejora Continua no encontrados"));

        existingDatos.setAlcance(datosDTO.getAlcance());
        existingDatos.setNumeroControl(datosDTO.getNumeroControl());
        existingDatos.setObjetivo(datosDTO.getObjetivo());
        existingDatos.setOrigenMejora(datosDTO.getOrigenMejora());
        existingDatos.setDescripcionAccion(datosDTO.getDescripcionAccion());
        existingDatos.setDescriocion(datosDTO.getDescriocion());
        existingDatos.setCuantificacion(datosDTO.getCuantificacion());
        existingDatos.setPeriodo(datosDTO.getPeriodo());
        existingDatos.setTiempoInicial(datosDTO.getTiempoInicial());
        existingDatos.setTiempoFinal(datosDTO.getTiempoFinal());
        existingDatos.setResultado(datosDTO.getResultado());

        DatosMejoraContinua updatedDatos = datosRepository.save(existingDatos);
        return datosMapper.toDTO(updatedDatos);
    }

    @Override
    public void deleteById(Long id) {
        datosRepository.deleteById(id);
    }
}

