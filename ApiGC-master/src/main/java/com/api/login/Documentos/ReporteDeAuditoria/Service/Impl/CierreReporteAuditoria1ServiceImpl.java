package com.api.login.Documentos.ReporteDeAuditoria.Service.Impl;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria1DTO;
import com.api.login.Documentos.ReporteDeAuditoria.Mapper.CierreReporteAuditoria1Mapper;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.CierreReporteAuditoria1;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.CierreReporteAuditoria1Repository;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.ReporteAuditoriaRepository;
import com.api.login.Documentos.ReporteDeAuditoria.Service.CierreReporteAuditoria1Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CierreReporteAuditoria1ServiceImpl implements CierreReporteAuditoria1Service {

    @Autowired
    private CierreReporteAuditoria1Repository cierreRepository;

    @Autowired
    private ReporteAuditoriaRepository reporteAuditoriaRepository;

    @Autowired
    private CierreReporteAuditoria1Mapper cierreMapper;

    @Override
    public List<CierreReporteAuditoria1DTO> findAll() {
        return cierreRepository.findAll().stream()
                .map(cierreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CierreReporteAuditoria1DTO findById(Long id) {
        CierreReporteAuditoria1 cierre = cierreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cierre de Reporte de Auditoría no encontrado"));
        return cierreMapper.toDTO(cierre);
    }

    @Override
    public List<CierreReporteAuditoria1DTO> findByReporteAuditoria(Long idReporteAuditoria) {
        List<CierreReporteAuditoria1> cierres = cierreRepository.findByReporteAuditoria_IdReporteAuditoria(idReporteAuditoria);
        return cierres.stream()
                .map(cierreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CierreReporteAuditoria1DTO save(CierreReporteAuditoria1DTO cierreDTO) {
        ReporteAuditoria reporteAuditoria = reporteAuditoriaRepository
                .findById(cierreDTO.getIdReporteAuditoria())
                .orElseThrow(() -> new EntityNotFoundException("Reporte de Auditoría no encontrado"));

        CierreReporteAuditoria1 cierre = cierreMapper.toEntity(cierreDTO, reporteAuditoria);
        CierreReporteAuditoria1 savedCierre = cierreRepository.save(cierre);
        return cierreMapper.toDTO(savedCierre);
    }

    @Override
    public CierreReporteAuditoria1DTO update(Long id, CierreReporteAuditoria1DTO cierreDTO) {
        CierreReporteAuditoria1 existingCierre = cierreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cierre de Reporte de Auditoría no encontrado"));

        existingCierre.setNombreAuditor(cierreDTO.getNombreAuditor());
        existingCierre.setFirma(cierreDTO.getFirma());

        CierreReporteAuditoria1 updatedCierre = cierreRepository.save(existingCierre);
        return cierreMapper.toDTO(updatedCierre);
    }

    @Override
    public void deleteById(Long id) {
        cierreRepository.deleteById(id);
    }
}
