package com.api.login.Documentos.PlanAuditorias.Service.Impl;

import com.api.login.Documentos.PlanAuditorias.DTO.PlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Dao.PlanAuditoriasDao;
import com.api.login.Documentos.PlanAuditorias.Mapper.PlanAuditoriasMapper;
import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Pojo.TablaPlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Service.ContenidoPlanAuditoriasService;
import com.api.login.Documentos.PlanAuditorias.Service.PlanAuditoriasService;
import com.api.login.Documentos.PlanAuditorias.Service.TablaPlanAuditoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanAuditoriasServiceImpl implements PlanAuditoriasService {
    @Autowired
    private PlanAuditoriasDao dao;

    @Autowired
    private PlanAuditoriasMapper mapper;

    @Autowired
    private ContenidoPlanAuditoriasService contenidoPlanAuditoriasService;

    @Autowired
    private TablaPlanAuditoriasService tablaPlanAuditoriasService;

    @Override
    public List<PlanAuditoriasDTO> getAllPlanAun() {
        List<PlanAuditorias> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOPlanAu)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlanAuditoriasDTO> getPlanAuById(Long id) {
        Optional<PlanAuditorias> optional = dao.findById(id);
        return optional.map(mapper::toDTOPlanAu);
    }

    @Override
    public PlanAuditoriasDTO createPlanAu(PlanAuditoriasDTO dto) {
        PlanAuditorias entity = mapper.toEntityPlanAu(dto);
        entity = dao.save(entity);
        return mapper.toDTOPlanAu(entity);
    }

    @Override
    public PlanAuditoriasDTO updatePlanAu(Long id, PlanAuditoriasDTO dto) {
        Optional<PlanAuditorias> optional = dao.findById(id);
        if (optional.isPresent()){
            PlanAuditorias entity = optional.get();
            entity.setCoDocumento(dto.getCoDocumento());
            entity.setNoRevision(dto.getNoRevision());
            entity.setFechaEmicion(dto.getFechaEmicion());
            entity.setFechaRevision(dto.getFechaRevision());
            entity = dao.save(entity);
            return mapper.toDTOPlanAu(entity);
        }
        return null;
    }

    @Override
    public void deletePlanAu(Long id) {
        Optional<PlanAuditorias> optional = dao.findById(id);

        if (optional.isPresent()){

            PlanAuditorias entity = optional.get();
            try {
                contenidoPlanAuditoriasService.deleteConPlanAu(entity.getContenidoPlanAuditorias().getIdContenidoPlanAuditorias());
            }catch (Exception e){

            }

            for (TablaPlanAuditorias tablaPlanAuditorias : entity.getTablaPlanAuditorias()){
                tablaPlanAuditoriasService.deleteConPlanAu(tablaPlanAuditorias.getIdTablaPlanAuditorias());
            }

            dao.deleteById(id);
        }

    }
}
