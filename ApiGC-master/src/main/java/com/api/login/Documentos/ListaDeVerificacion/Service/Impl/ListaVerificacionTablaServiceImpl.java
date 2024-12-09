package com.api.login.Documentos.ListaDeVerificacion.Service.Impl;

import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionTablaDTO;
import com.api.login.Documentos.ListaDeVerificacion.Mapper.ListaVerificacionTablaMapper;
import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacion;
import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacionTabla;
import com.api.login.Documentos.ListaDeVerificacion.Repository.ListaVerificacionRepository;
import com.api.login.Documentos.ListaDeVerificacion.Repository.ListaVerificacionTablaRepository;
import com.api.login.Documentos.ListaDeVerificacion.Service.ListaVerificacionTablaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaVerificacionTablaServiceImpl implements ListaVerificacionTablaService {

    @Autowired
    private ListaVerificacionTablaRepository listaVerificacionTablaRepository;

    @Autowired
    private ListaVerificacionRepository listaVerificacionRepository;

    @Autowired
    private ListaVerificacionTablaMapper listaVerificacionTablaMapper;

    @Override
    public List<ListaVerificacionTablaDTO> findAll() {
        return listaVerificacionTablaRepository.findAll().stream()
                .map(listaVerificacionTablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ListaVerificacionTablaDTO findById(Long id) {
        ListaVerificacionTabla tabla = listaVerificacionTablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Registro de tabla no encontrado"));
        return listaVerificacionTablaMapper.toDTO(tabla);
    }

    @Override
    public List<ListaVerificacionTablaDTO> findByListaVerificacion(Long idListaVerificacion) {
        List<ListaVerificacionTabla> tablas = listaVerificacionTablaRepository
                .findByListaVerificacion_IdListaVerificacion(idListaVerificacion);
        return tablas.stream()
                .map(listaVerificacionTablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ListaVerificacionTablaDTO save(ListaVerificacionTablaDTO listaVerificacionTablaDTO) {
        ListaVerificacion listaVerificacion = listaVerificacionRepository
                .findById(listaVerificacionTablaDTO.getIdListaVerificacion())
                .orElseThrow(() -> new EntityNotFoundException("Lista de verificación no encontrada"));

        ListaVerificacionTabla tabla = listaVerificacionTablaMapper.toEntity(listaVerificacionTablaDTO, listaVerificacion);
        ListaVerificacionTabla savedTabla = listaVerificacionTablaRepository.save(tabla);
        return listaVerificacionTablaMapper.toDTO(savedTabla);
    }

    @Override
    public ListaVerificacionTablaDTO update(Long id, ListaVerificacionTablaDTO listaVerificacionTablaDTO) {
        ListaVerificacionTabla existingTabla = listaVerificacionTablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Registro de tabla no encontrado"));

        existingTabla.setNumero(listaVerificacionTablaDTO.getNumero());
        existingTabla.setContextoOrganizacion(listaVerificacionTablaDTO.getContextoOrganizacion());
        existingTabla.setMarcador(listaVerificacionTablaDTO.getMarcador());
        existingTabla.setEvidenciasAllasgos(listaVerificacionTablaDTO.getEvidenciasAllasgos());

        ListaVerificacionTabla updatedTabla = listaVerificacionTablaRepository.save(existingTabla);
        return listaVerificacionTablaMapper.toDTO(updatedTabla);
    }

    @Override
    public void deleteById(Long id) {
        listaVerificacionTablaRepository.deleteById(id);
    }
}

