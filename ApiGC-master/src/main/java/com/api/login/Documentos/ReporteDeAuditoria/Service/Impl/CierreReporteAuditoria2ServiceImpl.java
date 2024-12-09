package com.api.login.Documentos.ReporteDeAuditoria.Service.Impl;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria2DTO;
import com.api.login.Documentos.ReporteDeAuditoria.Mapper.CierreReporteAuditoria2Mapper;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.CierreReporteAuditoria2;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.CierreReporteAuditoria2Repository;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.ReporteAuditoriaRepository;
import com.api.login.Documentos.ReporteDeAuditoria.Service.CierreReporteAuditoria2Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CierreReporteAuditoria2ServiceImpl implements CierreReporteAuditoria2Service {

    @Autowired
    private CierreReporteAuditoria2Repository cierreRepository;

    @Autowired
    private ReporteAuditoriaRepository reporteAuditoriaRepository;

    @Autowired
    private CierreReporteAuditoria2Mapper cierreMapper;

    @Override
    public List<CierreReporteAuditoria2DTO> findAll() {
        return cierreRepository.findAll().stream()
                .map(cierreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CierreReporteAuditoria2DTO findById(Long id) {
        CierreReporteAuditoria2 cierre = cierreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cierre de Reporte de Auditoría no encontrado"));
        return cierreMapper.toDTO(cierre);
    }

    @Override
    public List<CierreReporteAuditoria2DTO> findByReporteAuditoria(Long idReporteAuditoria) {
        List<CierreReporteAuditoria2> cierres = cierreRepository.findByReporteAuditoria_IdReporteAuditoria(idReporteAuditoria);
        return cierres.stream()
                .map(cierreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CierreReporteAuditoria2DTO save(CierreReporteAuditoria2DTO cierreDTO) {
        ReporteAuditoria reporteAuditoria = reporteAuditoriaRepository
                .findById(cierreDTO.getIdReporteAuditoria())
                .orElseThrow(() -> new EntityNotFoundException("Reporte de Auditoría no encontrado"));

        CierreReporteAuditoria2 cierre = cierreMapper.toEntity(cierreDTO, reporteAuditoria);
        CierreReporteAuditoria2 savedCierre = cierreRepository.save(cierre);
        return cierreMapper.toDTO(savedCierre);
    }

    @Override
    public CierreReporteAuditoria2DTO update(Long id, CierreReporteAuditoria2DTO cierreDTO) {
        CierreReporteAuditoria2 existingCierre = cierreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cierre de Reporte de Auditoría no encontrado"));

        existingCierre.setNombreAuditor(cierreDTO.getNombreAuditor());
        existingCierre.setFirma(cierreDTO.getFirma());

        CierreReporteAuditoria2 updatedCierre = cierreRepository.save(existingCierre);
        return cierreMapper.toDTO(updatedCierre);
    }

    @Override
    public void deleteById(Long id) {
        cierreRepository.deleteById(id);
    }
}

