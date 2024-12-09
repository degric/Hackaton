package com.api.login.Documentos.PlanAuditorias.Service.Impl;

import com.api.login.Documentos.PlanAuditorias.DTO.AuditoresPlanAuDTO;
import com.api.login.Documentos.PlanAuditorias.DTO.PlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Dao.AuditoresPlanAuDao;
import com.api.login.Documentos.PlanAuditorias.Mapper.AuditoresPlanAuMapper;
import com.api.login.Documentos.PlanAuditorias.Mapper.PlanAuditoriasMapper;
import com.api.login.Documentos.PlanAuditorias.Pojo.AuditoresPlanAu;
import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Service.AuditoresPlanAuService;
import com.api.login.Documentos.PlanAuditorias.Service.PlanAuditoriasService;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditoresPlanAuServiceImpl implements AuditoresPlanAuService {

    @Autowired
    private AuditoresPlanAuDao dao;

    @Autowired
    private AuditoresPlanAuMapper mapper;

    @Autowired
    private PlanAuditoriasService planAuditoriasService;

    @Autowired
    private PlanAuditoriasMapper planAuditoriasMapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosDao;

    @Override
    public List<AuditoresPlanAuDTO> getAllConPlanAu() {
        List<AuditoresPlanAu> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOConPlanAu)
                .collect(Collectors.toList());
    }

    @Override
    public AuditoresPlanAuDTO createConPlanAu(AuditoresPlanAuDTO dto) {
        PlanAuditoriasDTO planAuditoriasDTO = planAuditoriasService.getPlanAuById(dto.getIdPlanAuditorias()).orElse(null);
        if (planAuditoriasDTO == null) {
            return null;
        }
        PlanAuditorias planAuditorias = planAuditoriasMapper.toEntityPlanAu(planAuditoriasDTO);

        AuditoresPlanAu auditoresPlanAu = mapper.toEntityConPlanAu(dto, planAuditorias);

        // Guardado en el machote de Manual de Calidad
        Optional<MachoteDocumentos> optional = machoteDocumentosDao.findByNombreDocumento("Plan de auditorías");

        if (optional.isPresent()) {
            MachoteDocumentos existingMachoteDocumentos = optional.get();
            existingMachoteDocumentos.setIdDocumento(planAuditorias.getIdPlanAuditorias());
            machoteDocumentosDao.save(existingMachoteDocumentos);
        } else {
            MachoteDocumentos newMachoteDocumentos = new MachoteDocumentos();
            newMachoteDocumentos.setNombreDocumento("Plan de auditorías");
            newMachoteDocumentos.setIdDocumento(planAuditorias.getIdPlanAuditorias());
            newMachoteDocumentos.setNivelDocumento(2);
            newMachoteDocumentos.setCodigoDocumento(planAuditorias.getCoDocumento());
            machoteDocumentosDao.save(newMachoteDocumentos);
        }
        return mapper.toDTOConPlanAu(dao.save(auditoresPlanAu));
    }

    @Override
    public AuditoresPlanAuDTO updateConPlanAu(Long id, AuditoresPlanAuDTO dto) {
        Optional<AuditoresPlanAu> optional = dao.findById(id);
        if (optional.isPresent()) {
            AuditoresPlanAu entity = optional.get();
            entity.setAuditor(dto.getAuditor());
            PlanAuditoriasDTO planAuditorias = planAuditoriasService.getPlanAuById(dto.getIdPlanAuditorias()).orElse(null);
            entity.setPlanAuditorias(planAuditoriasMapper.toEntityPlanAu(planAuditorias));
            return mapper.toDTOConPlanAu(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteConPlanAu(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<AuditoresPlanAuDTO> getByIdEncabezado(Long id) {
        List<AuditoresPlanAu> entity = dao.findByPlanAuditoriasIdPlanAuditorias(id);
        return entity.stream()
                .map(mapper::toDTOConPlanAu)
                .collect(Collectors.toList());
    }
}

