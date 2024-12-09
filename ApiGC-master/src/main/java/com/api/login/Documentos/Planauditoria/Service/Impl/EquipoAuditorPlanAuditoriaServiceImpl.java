package com.api.login.Documentos.Planauditoria.Service.Impl;

import com.api.login.Documentos.Planauditoria.DTO.EquipoAuditorPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Mapper.EquipoAuditorPlanAuditoriaMapper;
import com.api.login.Documentos.Planauditoria.Pojo.EquipoAuditorPlanAuditoria;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import com.api.login.Documentos.Planauditoria.Repository.EquipoAuditorPlanAuditoriaRepository;
import com.api.login.Documentos.Planauditoria.Repository.PlanAuditoriaRepository;
import com.api.login.Documentos.Planauditoria.Service.EquipoAuditorPlanAuditoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoAuditorPlanAuditoriaServiceImpl implements EquipoAuditorPlanAuditoriaService {

    @Autowired
    private EquipoAuditorPlanAuditoriaRepository equipoAuditorRepository;

    @Autowired
    private PlanAuditoriaRepository planAuditoriaRepository;

    @Autowired
    private EquipoAuditorPlanAuditoriaMapper equipoAuditorMapper;

    @Override
    public List<EquipoAuditorPlanAuditoriaDTO> findAll() {
        return equipoAuditorRepository.findAll().stream()
                .map(equipoAuditorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoAuditorPlanAuditoriaDTO findById(Long id) {
        EquipoAuditorPlanAuditoria equipo = equipoAuditorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipo Auditor no encontrado"));
        return equipoAuditorMapper.toDTO(equipo);
    }

    @Override
    public List<EquipoAuditorPlanAuditoriaDTO> findByPlanAuditoria(Long idPlanAuditoria) {
        List<EquipoAuditorPlanAuditoria> equipoList = equipoAuditorRepository
                .findByPlanAuditoria_IdPlanAuditoria(idPlanAuditoria);
        return equipoList.stream()
                .map(equipoAuditorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoAuditorPlanAuditoriaDTO save(EquipoAuditorPlanAuditoriaDTO equipoAuditorDTO) {
        PlanAuditoria planAuditoria = planAuditoriaRepository
                .findById(equipoAuditorDTO.getIdPlanAuditoria())
                .orElseThrow(() -> new EntityNotFoundException("Plan de Auditoría no encontrado"));

        EquipoAuditorPlanAuditoria equipo = equipoAuditorMapper.toEntity(equipoAuditorDTO, planAuditoria);
        EquipoAuditorPlanAuditoria savedEquipo = equipoAuditorRepository.save(equipo);
        return equipoAuditorMapper.toDTO(savedEquipo);
    }

    @Override
    public EquipoAuditorPlanAuditoriaDTO update(Long id, EquipoAuditorPlanAuditoriaDTO equipoAuditorDTO) {
        EquipoAuditorPlanAuditoria existingEquipo = equipoAuditorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipo Auditor no encontrado"));

        existingEquipo.setAuditorLider(equipoAuditorDTO.getAuditorLider());
        existingEquipo.setAuditores(equipoAuditorDTO.getAuditores());
        existingEquipo.setAuditoresEntrenamiento(equipoAuditorDTO.getAuditoresEntrenamiento());

        EquipoAuditorPlanAuditoria updatedEquipo = equipoAuditorRepository.save(existingEquipo);
        return equipoAuditorMapper.toDTO(updatedEquipo);
    }

    @Override
    public void deleteById(Long id) {
        equipoAuditorRepository.deleteById(id);
    }
}
