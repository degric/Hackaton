package com.api.login.Documentos.Planauditoria.Service.Impl;

import com.api.login.Documentos.Planauditoria.DTO.DatosPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Mapper.DatosPlanAuditoriaMapper;
import com.api.login.Documentos.Planauditoria.Pojo.DatosPlanAuditoria;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import com.api.login.Documentos.Planauditoria.Repository.DatosPlanAuditoriaRepository;
import com.api.login.Documentos.Planauditoria.Repository.PlanAuditoriaRepository;
import com.api.login.Documentos.Planauditoria.Service.DatosPlanAuditoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatosPlanAuditoriaServiceImpl implements DatosPlanAuditoriaService {

    @Autowired
    private DatosPlanAuditoriaRepository datosPlanAuditoriaRepository;

    @Autowired
    private PlanAuditoriaRepository planAuditoriaRepository;

    @Autowired
    private DatosPlanAuditoriaMapper datosPlanAuditoriaMapper;

    @Override
    public List<DatosPlanAuditoriaDTO> findAll() {
        return datosPlanAuditoriaRepository.findAll().stream()
                .map(datosPlanAuditoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DatosPlanAuditoriaDTO findById(Long id) {
        DatosPlanAuditoria datos = datosPlanAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Plan de Auditoría no encontrados"));
        return datosPlanAuditoriaMapper.toDTO(datos);
    }

    @Override
    public List<DatosPlanAuditoriaDTO> findByPlanAuditoria(Long idPlanAuditoria) {
        List<DatosPlanAuditoria> datosList = datosPlanAuditoriaRepository
                .findByPlanAuditoria_IdPlanAuditoria(idPlanAuditoria);
        return datosList.stream()
                .map(datosPlanAuditoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DatosPlanAuditoriaDTO save(DatosPlanAuditoriaDTO datosPlanAuditoriaDTO) {
        PlanAuditoria planAuditoria = planAuditoriaRepository
                .findById(datosPlanAuditoriaDTO.getIdPlanAuditoria())
                .orElseThrow(() -> new EntityNotFoundException("Plan de Auditoría no encontrado"));

        DatosPlanAuditoria datos = datosPlanAuditoriaMapper.toEntity(datosPlanAuditoriaDTO, planAuditoria);
        DatosPlanAuditoria savedDatos = datosPlanAuditoriaRepository.save(datos);
        return datosPlanAuditoriaMapper.toDTO(savedDatos);
    }

    @Override
    public DatosPlanAuditoriaDTO update(Long id, DatosPlanAuditoriaDTO datosPlanAuditoriaDTO) {
        DatosPlanAuditoria existingDatos = datosPlanAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos de Plan de Auditoría no encontrados"));

        existingDatos.setObjetivoAuditoria(datosPlanAuditoriaDTO.getObjetivoAuditoria());
        existingDatos.setAlcanceAuditoria(datosPlanAuditoriaDTO.getAlcanceAuditoria());
        existingDatos.setCriteriosAuditorias(datosPlanAuditoriaDTO.getCriteriosAuditorias());
        existingDatos.setFechaElaboracion(datosPlanAuditoriaDTO.getFechaElaboracion());
        existingDatos.setNoAuditoria(datosPlanAuditoriaDTO.getNoAuditoria());
        existingDatos.setFechaInicio(datosPlanAuditoriaDTO.getFechaInicio());
        existingDatos.setFechaTermino(datosPlanAuditoriaDTO.getFechaTermino());

        DatosPlanAuditoria updatedDatos = datosPlanAuditoriaRepository.save(existingDatos);
        return datosPlanAuditoriaMapper.toDTO(updatedDatos);
    }

    @Override
    public void deleteById(Long id) {
        datosPlanAuditoriaRepository.deleteById(id);
    }
}
