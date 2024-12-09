package com.api.login.Documentos.ReporteDeAuditoria.Service.Impl;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.InfoReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Mapper.InfoReporteAuditoriaMapper;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.InfoReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.InfoReporteAuditoriaRepository;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.ReporteAuditoriaRepository;
import com.api.login.Documentos.ReporteDeAuditoria.Service.InfoReporteAuditoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InfoReporteAuditoriaServiceImpl implements InfoReporteAuditoriaService {

    @Autowired
    private InfoReporteAuditoriaRepository infoReporteAuditoriaRepository;

    @Autowired
    private ReporteAuditoriaRepository reporteAuditoriaRepository;

    @Autowired
    private InfoReporteAuditoriaMapper infoReporteAuditoriaMapper;

    @Override
    public List<InfoReporteAuditoriaDTO> findAll() {
        return infoReporteAuditoriaRepository.findAll().stream()
                .map(infoReporteAuditoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InfoReporteAuditoriaDTO findById(Long id) {
        InfoReporteAuditoria info = infoReporteAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Información del Reporte de Auditoría no encontrada"));
        return infoReporteAuditoriaMapper.toDTO(info);
    }

    @Override
    public InfoReporteAuditoriaDTO findByReporteAuditoria(Long idReporteAuditoria) {
        InfoReporteAuditoria info = infoReporteAuditoriaRepository.findByReporteAuditoria_IdReporteAuditoria(idReporteAuditoria)
                .orElseThrow(() -> new EntityNotFoundException("Información del Reporte de Auditoría no encontrada para el reporte especificado"));
        return infoReporteAuditoriaMapper.toDTO(info);
    }

    @Override
    public InfoReporteAuditoriaDTO save(InfoReporteAuditoriaDTO infoReporteAuditoriaDTO) {
        ReporteAuditoria reporteAuditoria = reporteAuditoriaRepository
                .findById(infoReporteAuditoriaDTO.getIdReporteAuditoria())
                .orElseThrow(() -> new EntityNotFoundException("Reporte de Auditoría no encontrado"));

        InfoReporteAuditoria info = infoReporteAuditoriaMapper.toEntity(infoReporteAuditoriaDTO, reporteAuditoria);
        InfoReporteAuditoria savedInfo = infoReporteAuditoriaRepository.save(info);
        return infoReporteAuditoriaMapper.toDTO(savedInfo);
    }

    @Override
    public InfoReporteAuditoriaDTO update(Long id, InfoReporteAuditoriaDTO infoReporteAuditoriaDTO) {
        InfoReporteAuditoria existingInfo = infoReporteAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Información del Reporte de Auditoría no encontrada"));

        existingInfo.setProcesoAuditado(infoReporteAuditoriaDTO.getProcesoAuditado());
        existingInfo.setResponSGC(infoReporteAuditoriaDTO.getResponSGC());
        existingInfo.setFecha(infoReporteAuditoriaDTO.getFecha());
        existingInfo.setNoAuditoria(infoReporteAuditoriaDTO.getNoAuditoria());
        existingInfo.setCalificacion(infoReporteAuditoriaDTO.getCalificacion());

        InfoReporteAuditoria updatedInfo = infoReporteAuditoriaRepository.save(existingInfo);
        return infoReporteAuditoriaMapper.toDTO(updatedInfo);
    }

    @Override
    public void deleteById(Long id) {
        infoReporteAuditoriaRepository.deleteById(id);
    }
}
