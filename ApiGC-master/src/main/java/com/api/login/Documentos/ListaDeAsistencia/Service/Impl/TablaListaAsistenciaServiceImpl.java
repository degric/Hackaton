package com.api.login.Documentos.ListaDeAsistencia.Service.Impl;

import com.api.login.Documentos.ListaDeAsistencia.DTO.TablaListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Mapper.TablaListaAsistenciaMapper;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.ListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.TablaListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Repository.ListaAsistenciaRepository;
import com.api.login.Documentos.ListaDeAsistencia.Repository.TablaListaAsistenciaRepository;
import com.api.login.Documentos.ListaDeAsistencia.Service.TablaListaAsistenciaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TablaListaAsistenciaServiceImpl implements TablaListaAsistenciaService {

    @Autowired
    private TablaListaAsistenciaRepository tablaRepository;

    @Autowired
    private ListaAsistenciaRepository listaRepository;

    @Autowired
    private TablaListaAsistenciaMapper tablaMapper;

    @Override
    public List<TablaListaAsistenciaDTO> findAll() {
        return tablaRepository.findAll().stream()
                .map(tablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaListaAsistenciaDTO findById(Long id) {
        TablaListaAsistencia tabla = tablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante no encontrado"));
        return tablaMapper.toDTO(tabla);
    }

    @Override
    public List<TablaListaAsistenciaDTO> findByListaAsistencia(Long idListaAsistencia) {
        List<TablaListaAsistencia> tablas = tablaRepository.findByListaAsistencia_IdListaAsistencia(idListaAsistencia);
        return tablas.stream()
                .map(tablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaListaAsistenciaDTO save(TablaListaAsistenciaDTO tablaDTO) {
        ListaAsistencia listaAsistencia = listaRepository.findById(tablaDTO.getIdListaAsistencia())
                .orElseThrow(() -> new EntityNotFoundException("Lista de Asistencia no encontrada"));

        TablaListaAsistencia tabla = tablaMapper.toEntity(tablaDTO, listaAsistencia);
        TablaListaAsistencia savedTabla = tablaRepository.save(tabla);
        return tablaMapper.toDTO(savedTabla);
    }

    @Override
    public TablaListaAsistenciaDTO update(Long id, TablaListaAsistenciaDTO tablaDTO) {
        TablaListaAsistencia existingTabla = tablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante no encontrado"));

        existingTabla.setNombreParticipante(tablaDTO.getNombreParticipante());
        existingTabla.setPuesto(tablaDTO.getPuesto());
        existingTabla.setFirma(tablaDTO.getFirma());

        TablaListaAsistencia updatedTabla = tablaRepository.save(existingTabla);
        return tablaMapper.toDTO(updatedTabla);
    }

    @Override
    public void deleteById(Long id) {
        tablaRepository.deleteById(id);
    }
}

