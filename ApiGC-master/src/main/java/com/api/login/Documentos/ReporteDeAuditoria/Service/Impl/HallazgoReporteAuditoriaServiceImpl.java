package com.api.login.Documentos.ReporteDeAuditoria.Service.Impl;


import com.api.login.Documentos.ReporteDeAuditoria.DTO.HallazgoReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Mapper.HallazgoReporteAuditoriaMapper;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.HallazgoReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.HallazgoReporteAuditoriaRepository;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.ReporteAuditoriaRepository;
import com.api.login.Documentos.ReporteDeAuditoria.Service.HallazgoReporteAuditoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallazgoReporteAuditoriaServiceImpl implements HallazgoReporteAuditoriaService {

    @Autowired
    private HallazgoReporteAuditoriaRepository hallazgoRepository;

    @Autowired
    private ReporteAuditoriaRepository reporteAuditoriaRepository;

    @Autowired
    private HallazgoReporteAuditoriaMapper hallazgoMapper;

    @Override
    public List<HallazgoReporteAuditoriaDTO> findAll() {
        return hallazgoRepository.findAll().stream()
                .map(hallazgoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HallazgoReporteAuditoriaDTO findById(Long id) {
        HallazgoReporteAuditoria hallazgo = hallazgoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hallazgo de Reporte de Auditoría no encontrado"));
        return hallazgoMapper.toDTO(hallazgo);
    }

    @Override
    public List<HallazgoReporteAuditoriaDTO> findByReporteAuditoria(Long idReporteAuditoria) {
        List<HallazgoReporteAuditoria> hallazgos = hallazgoRepository.findByReporteAuditoria_IdReporteAuditoria(idReporteAuditoria);
        return hallazgos.stream()
                .map(hallazgoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HallazgoReporteAuditoriaDTO save(HallazgoReporteAuditoriaDTO hallazgoDTO) {
        ReporteAuditoria reporteAuditoria = reporteAuditoriaRepository
                .findById(hallazgoDTO.getIdReporteAuditoria())
                .orElseThrow(() -> new EntityNotFoundException("Reporte de Auditoría no encontrado"));

        HallazgoReporteAuditoria hallazgo = hallazgoMapper.toEntity(hallazgoDTO, reporteAuditoria);
        HallazgoReporteAuditoria savedHallazgo = hallazgoRepository.save(hallazgo);
        return hallazgoMapper.toDTO(savedHallazgo);
    }

    @Override
    public HallazgoReporteAuditoriaDTO update(Long id, HallazgoReporteAuditoriaDTO hallazgoDTO) {
        HallazgoReporteAuditoria existingHallazgo = hallazgoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hallazgo de Reporte de Auditoría no encontrado"));

        existingHallazgo.setClausulaNorma(hallazgoDTO.getClausulaNorma());
        existingHallazgo.setTipoHallazgo(hallazgoDTO.getTipoHallazgo());
        existingHallazgo.setComentario(hallazgoDTO.getComentario());

        HallazgoReporteAuditoria updatedHallazgo = hallazgoRepository.save(existingHallazgo);
        return hallazgoMapper.toDTO(updatedHallazgo);
    }

    @Override
    public void deleteById(Long id) {
        hallazgoRepository.deleteById(id);
    }
}

