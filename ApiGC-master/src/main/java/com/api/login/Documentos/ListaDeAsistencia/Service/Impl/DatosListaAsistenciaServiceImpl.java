package com.api.login.Documentos.ListaDeAsistencia.Service.Impl;

import com.api.login.Documentos.ListaDeAsistencia.DTO.DatosListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Mapper.DatosListaAsistenciaMapper;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.DatosListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.ListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Repository.DatosListaAsistenciaRepository;
import com.api.login.Documentos.ListaDeAsistencia.Repository.ListaAsistenciaRepository;
import com.api.login.Documentos.ListaDeAsistencia.Service.DatosListaAsistenciaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatosListaAsistenciaServiceImpl implements DatosListaAsistenciaService {

    @Autowired
    private DatosListaAsistenciaRepository datosRepository;

    @Autowired
    private ListaAsistenciaRepository listaRepository;

    @Autowired
    private DatosListaAsistenciaMapper datosMapper;

    @Override
    public List<DatosListaAsistenciaDTO> findAll() {
        return datosRepository.findAll().stream()
                .map(datosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DatosListaAsistenciaDTO findById(Long id) {
        DatosListaAsistencia datos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Lista de Asistencia no encontrados"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosListaAsistenciaDTO findByListaAsistencia(Long idListaAsistencia) {
        DatosListaAsistencia datos = datosRepository.findByListaAsistencia_IdListaAsistencia(idListaAsistencia)
                .orElseThrow(() -> new EntityNotFoundException("Datos no encontrados para la Lista de Asistencia especificada"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosListaAsistenciaDTO save(DatosListaAsistenciaDTO datosDTO) {
        ListaAsistencia listaAsistencia = listaRepository
                .findById(datosDTO.getIdListaAsistencia())
                .orElseThrow(() -> new EntityNotFoundException("Lista de Asistencia no encontrada"));

        DatosListaAsistencia datos = datosMapper.toEntity(datosDTO, listaAsistencia);
        DatosListaAsistencia savedDatos = datosRepository.save(datos);
        return datosMapper.toDTO(savedDatos);
    }

    @Override
    public DatosListaAsistenciaDTO update(Long id, DatosListaAsistenciaDTO datosDTO) {
        DatosListaAsistencia existingDatos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Lista de Asistencia no encontrados"));

        existingDatos.setDepartamentoCoordinador(datosDTO.getDepartamentoCoordinador());
        existingDatos.setResponable(datosDTO.getResponable());
        existingDatos.setTitulo(datosDTO.getTitulo());
        existingDatos.setFecha(datosDTO.getFecha());

        DatosListaAsistencia updatedDatos = datosRepository.save(existingDatos);
        return datosMapper.toDTO(updatedDatos);
    }

    @Override
    public void deleteById(Long id) {
        datosRepository.deleteById(id);
    }
}

