package com.api.login.Documentos.Planauditoria.Service.Impl;

import com.api.login.Documentos.Planauditoria.DTO.ObservacionesPlanAuditoriasDTO;
import com.api.login.Documentos.Planauditoria.Mapper.ObservacionesPlanAuditoriasMapper;
import com.api.login.Documentos.Planauditoria.Pojo.ObservacionesPlanAuditorias;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import com.api.login.Documentos.Planauditoria.Repository.ObservacionesPlanAuditoriasRepository;
import com.api.login.Documentos.Planauditoria.Repository.PlanAuditoriaRepository;
import com.api.login.Documentos.Planauditoria.Service.ObservacionesPlanAuditoriasService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObservacionesPlanAuditoriasServiceImpl implements ObservacionesPlanAuditoriasService {

    @Autowired
    private ObservacionesPlanAuditoriasRepository observacionesRepository;

    @Autowired
    private PlanAuditoriaRepository planAuditoriaRepository;

    @Autowired
    private ObservacionesPlanAuditoriasMapper observacionesMapper;

    @Override
    public List<ObservacionesPlanAuditoriasDTO> findAll() {
        return observacionesRepository.findAll().stream()
                .map(observacionesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ObservacionesPlanAuditoriasDTO findById(Long id) {
        ObservacionesPlanAuditorias observacion = observacionesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Observación no encontrada"));
        return observacionesMapper.toDTO(observacion);
    }

    @Override
    public List<ObservacionesPlanAuditoriasDTO> findByPlanAuditoria(Long idPlanAuditoria) {
        List<ObservacionesPlanAuditorias> observacionesList = observacionesRepository
                .findByPlanAuditoria_IdPlanAuditoria(idPlanAuditoria);
        return observacionesList.stream()
                .map(observacionesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ObservacionesPlanAuditoriasDTO save(ObservacionesPlanAuditoriasDTO observacionesDTO) {
        PlanAuditoria planAuditoria = planAuditoriaRepository
                .findById(observacionesDTO.getIdPlanAuditoria())
                .orElseThrow(() -> new EntityNotFoundException("Plan de Auditoría no encontrado"));

        ObservacionesPlanAuditorias observacion = observacionesMapper.toEntity(observacionesDTO, planAuditoria);
        ObservacionesPlanAuditorias savedObservacion = observacionesRepository.save(observacion);
        return observacionesMapper.toDTO(savedObservacion);
    }

    @Override
    public ObservacionesPlanAuditoriasDTO update(Long id, ObservacionesPlanAuditoriasDTO observacionesDTO) {
        ObservacionesPlanAuditorias existingObservacion = observacionesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Observación no encontrada"));

        existingObservacion.setObservacion(observacionesDTO.getObservacion());

        ObservacionesPlanAuditorias updatedObservacion = observacionesRepository.save(existingObservacion);
        return observacionesMapper.toDTO(updatedObservacion);
    }

    @Override
    public void deleteById(Long id) {
        observacionesRepository.deleteById(id);
    }
}

