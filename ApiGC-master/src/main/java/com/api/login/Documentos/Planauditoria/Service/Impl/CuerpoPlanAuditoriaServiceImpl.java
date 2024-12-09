package com.api.login.Documentos.Planauditoria.Service.Impl;

import com.api.login.Documentos.Planauditoria.DTO.CuerpoPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Mapper.CuerpoPlanAuditoriaMapper;
import com.api.login.Documentos.Planauditoria.Pojo.CuerpoPlanAuditoria;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import com.api.login.Documentos.Planauditoria.Repository.CuerpoPlanAuditoriaRepository;
import com.api.login.Documentos.Planauditoria.Repository.PlanAuditoriaRepository;
import com.api.login.Documentos.Planauditoria.Service.CuerpoPlanAuditoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuerpoPlanAuditoriaServiceImpl implements CuerpoPlanAuditoriaService {

    @Autowired
    private CuerpoPlanAuditoriaRepository cuerpoRepository;

    @Autowired
    private PlanAuditoriaRepository planAuditoriaRepository;

    @Autowired
    private CuerpoPlanAuditoriaMapper cuerpoMapper;

    @Override
    public List<CuerpoPlanAuditoriaDTO> findAll() {
        return cuerpoRepository.findAll().stream()
                .map(cuerpoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CuerpoPlanAuditoriaDTO findById(Long id) {
        CuerpoPlanAuditoria cuerpo = cuerpoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuerpo de Plan de Auditoría no encontrado"));
        return cuerpoMapper.toDTO(cuerpo);
    }

    @Override
    public List<CuerpoPlanAuditoriaDTO> findByPlanAuditoria(Long idPlanAuditoria) {
        List<CuerpoPlanAuditoria> cuerpoList = cuerpoRepository
                .findByPlanAuditoria_IdPlanAuditoria(idPlanAuditoria);
        return cuerpoList.stream()
                .map(cuerpoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CuerpoPlanAuditoriaDTO save(CuerpoPlanAuditoriaDTO cuerpoDTO) {
        PlanAuditoria planAuditoria = planAuditoriaRepository
                .findById(cuerpoDTO.getIdPlanAuditoria())
                .orElseThrow(() -> new EntityNotFoundException("Plan de Auditoría no encontrado"));

        CuerpoPlanAuditoria cuerpo = cuerpoMapper.toEntity(cuerpoDTO, planAuditoria);
        CuerpoPlanAuditoria savedCuerpo = cuerpoRepository.save(cuerpo);
        return cuerpoMapper.toDTO(savedCuerpo);
    }

    @Override
    public CuerpoPlanAuditoriaDTO update(Long id, CuerpoPlanAuditoriaDTO cuerpoDTO) {
        CuerpoPlanAuditoria existingCuerpo = cuerpoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuerpo de Plan de Auditoría no encontrado"));

        existingCuerpo.setInicio(cuerpoDTO.getInicio());
        existingCuerpo.setTermino(cuerpoDTO.getTermino());
        existingCuerpo.setProcesoAuditar(cuerpoDTO.getProcesoAuditar());
        existingCuerpo.setRequisitosNorma(cuerpoDTO.getRequisitosNorma());
        existingCuerpo.setContraparteAuditada(cuerpoDTO.getContraparteAuditada());
        existingCuerpo.setAuditor(cuerpoDTO.getAuditor());

        CuerpoPlanAuditoria updatedCuerpo = cuerpoRepository.save(existingCuerpo);
        return cuerpoMapper.toDTO(updatedCuerpo);
    }

    @Override
    public void deleteById(Long id) {
        cuerpoRepository.deleteById(id);
    }
}

