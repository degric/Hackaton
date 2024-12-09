package com.api.login.Documentos.PlanAuditorias.Service.Impl;

import com.api.login.Documentos.PlanAuditorias.DTO.PlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.DTO.TablaPlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Dao.TablaPlanAuditoriasDao;
import com.api.login.Documentos.PlanAuditorias.Mapper.PlanAuditoriasMapper;
import com.api.login.Documentos.PlanAuditorias.Mapper.TablaPlanAuditoriasMapper;
import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Pojo.TablaPlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Service.PlanAuditoriasService;
import com.api.login.Documentos.PlanAuditorias.Service.TablaPlanAuditoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TablaPlanAuditoriasServiceImpl implements TablaPlanAuditoriasService {

    @Autowired
    private TablaPlanAuditoriasDao dao;

    @Autowired
    private TablaPlanAuditoriasMapper mapper;

    @Autowired
    private PlanAuditoriasService planAuditoriasService;

    @Autowired
    private PlanAuditoriasMapper planAuditoriasMapper;

    @Override
    public List<TablaPlanAuditoriasDTO> getAllConPlanAu() {
        List<TablaPlanAuditorias> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOConPlanAu)
                .collect(Collectors.toList());
    }

    @Override
    public TablaPlanAuditoriasDTO createConPlanAu(TablaPlanAuditoriasDTO dto) {
        PlanAuditoriasDTO planAuditoriasDTO = planAuditoriasService.getPlanAuById(dto.getIdPlanAuditorias()).orElse(null);
        if (planAuditoriasDTO == null){
            return null;
        }
        PlanAuditorias planAuditorias = planAuditoriasMapper.toEntityPlanAu(planAuditoriasDTO);
        TablaPlanAuditorias tablaPlanAuditorias = mapper.toEntityConPlanAu(dto, planAuditorias);
        return mapper.toDTOConPlanAu(dao.save(tablaPlanAuditorias));
    }

    @Override
    public TablaPlanAuditoriasDTO updateConPlanAu(Long id, TablaPlanAuditoriasDTO dto) {
        Optional<TablaPlanAuditorias> optional = dao.findById(id);
        if (optional.isPresent()){
            TablaPlanAuditorias entity = optional.get();
            entity.setHorario(dto.getHorario());
            entity.setHoraFin(dto.getHoraFin());
            entity.setRequisito(dto.getRequisito());
            entity.setAuditor(dto.getAuditor());
            entity.setRequisito1(dto.getRequisito1());
            entity.setAuditor1(dto.getAuditor1());
            entity.setRequisito2(dto.getRequisito2());
            entity.setAuditor2(dto.getAuditor2());
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
    public List<TablaPlanAuditoriasDTO> getByIdEncabezado(Long id) {
        List<TablaPlanAuditorias> entity = dao.findByPlanAuditoriasIdPlanAuditorias(id);
        return entity.stream()
                .map(mapper::toDTOConPlanAu)
                .collect(Collectors.toList());
    }
}

