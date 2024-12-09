package com.api.login.Documentos.PlanAuditorias.Service.Impl;

import com.api.login.Documentos.PlanAuditorias.DTO.ContenidoPlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.DTO.PlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Dao.ContenidoPlanAuditoriasDao;
import com.api.login.Documentos.PlanAuditorias.Mapper.ContenidoPlanAuditoriasMapper;
import com.api.login.Documentos.PlanAuditorias.Mapper.PlanAuditoriasMapper;
import com.api.login.Documentos.PlanAuditorias.Pojo.ContenidoPlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Service.ContenidoPlanAuditoriasService;
import com.api.login.Documentos.PlanAuditorias.Service.PlanAuditoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContenidoPlanAuditoriasServiceImpl implements ContenidoPlanAuditoriasService {

    @Autowired
    private ContenidoPlanAuditoriasDao dao;

    @Autowired
    private ContenidoPlanAuditoriasMapper mapper;

    @Autowired
    private PlanAuditoriasService planAuditoriasService;

    @Autowired
    private PlanAuditoriasMapper planAuditoriasMapper;

    @Override
    public List<ContenidoPlanAuditoriasDTO> getAllConPlanAu() {
        List<ContenidoPlanAuditorias> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOConPlanAu)
                .collect(Collectors.toList());
    }

    @Override
    public ContenidoPlanAuditoriasDTO createConPlanAu(ContenidoPlanAuditoriasDTO dto) {
        PlanAuditoriasDTO planAuditoriasDTO = planAuditoriasService.getPlanAuById(dto.getIdPlanAuditorias()).orElse(null);
        if (planAuditoriasDTO == null){
            return null;
        }
        PlanAuditorias planAuditorias = planAuditoriasMapper.toEntityPlanAu(planAuditoriasDTO);
        if (dao.findByPlanAuditoriasIdPlanAuditorias(dto.getIdPlanAuditorias()).isPresent()){
            return null;
        }

        ContenidoPlanAuditorias contenidoPlanAuditorias = mapper.toEntityConPlanAu(dto, planAuditorias);
        return mapper.toDTOConPlanAu(dao.save(contenidoPlanAuditorias));
    }

    @Override
    public ContenidoPlanAuditoriasDTO updateConPlanAu(Long id, ContenidoPlanAuditoriasDTO dto) {
        Optional<ContenidoPlanAuditorias> optional = dao.findById(id);
        if (optional.isPresent()){
            ContenidoPlanAuditorias entity = optional.get();
            entity.setNoAuditoria(dto.getNoAuditoria());
            entity.setFecha(dto.getFecha());
            entity.setAreas(dto.getAreas());
            entity.setObjetivos(dto.getObjetivos());
            entity.setAlcance(dto.getAlcance());
            entity.setCriterios(dto.getCriterios());
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
    public Optional<ContenidoPlanAuditoriasDTO> getByIdEncabezado(Long id) {
        Optional<ContenidoPlanAuditorias> entity = dao.findByPlanAuditoriasIdPlanAuditorias(id);
        return entity.map(mapper::toDTOConPlanAu);
    }
}
