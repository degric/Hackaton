package com.api.login.Documentos.ProgramaAuditoriasInternas.Service.Impl;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ProgramaAuditoriasInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.TablaProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Dao.TablaProAuInternasDao;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper.ProgramaAuditoriasInternasMapper;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper.TablaProAuInternasMapper;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ProgramaAuditoriasInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.TablaProAuInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.ProgramaAuditoriasInternasService;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.TablaProAuInternasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TablaProAuInternasServiceImpl implements TablaProAuInternasService {

    @Autowired
    private TablaProAuInternasDao dao;

    @Autowired
    private TablaProAuInternasMapper mapper;

    @Autowired
    private ProgramaAuditoriasInternasService programaAuditoriasInternasService;

    @Autowired
    private ProgramaAuditoriasInternasMapper programaAuditoriasInternasMapper;

    @Override
    public List<TablaProAuInternasDTO> getAllTaProAuIn() {
        List<TablaProAuInternas> list = dao.findAll();
        return list.stream()
                .map(mapper::toDTOTaProAuIn)
                .collect(Collectors.toList());
    }

    @Override
    public TablaProAuInternas createTaProAuIn(TablaProAuInternasDTO dto) {
        ProgramaAuditoriasInternasDTO programaAuditoriasInternasDTO = programaAuditoriasInternasService.getByIdProAuIn(dto.getIdProgramaAuditoriasInternas()).orElse(null);
        if (programaAuditoriasInternasDTO == null) {
            return null;
        }
        ProgramaAuditoriasInternas programaAuditoriasInternas = programaAuditoriasInternasMapper.toEntityProAuIn(programaAuditoriasInternasDTO);

        TablaProAuInternas tablaProAuInternas = mapper.toEntityTaProAuIn(dto,programaAuditoriasInternas);
        return dao.save(tablaProAuInternas);
    }


    @Override
    public TablaProAuInternasDTO updatetaProAuIn(Integer id, TablaProAuInternasDTO dto) {
        Optional<TablaProAuInternas> optional = dao.findById(id);
        if (optional.isPresent()){
            TablaProAuInternas entity = optional.get();
            entity.setAreaAuditada(dto.getAreaAuditada());
            entity.setMes1AuIn(dto.getMes1AuIn());
            entity.setMes2AuIn(dto.getMes2AuIn());
            entity.setMesAuEx(dto.getMesAuEx());
            ProgramaAuditoriasInternasDTO programaAuditoriasInternasDTO = programaAuditoriasInternasService.getByIdProAuIn(dto.getIdProgramaAuditoriasInternas()).orElse(null);
            entity.setProgramaAuditoriasInternas(programaAuditoriasInternasMapper.toEntityProAuIn(programaAuditoriasInternasDTO));
            return mapper.toDTOTaProAuIn(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteTaProAuIn(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<TablaProAuInternasDTO> getByIdProgramaAuInternas(Integer id) {
        List<TablaProAuInternas> entity = dao.findByProgramaAuditoriasInternasIdProgramaAuditoriasInternas(id);
        return entity.stream()
                .map(mapper::toDTOTaProAuIn)
                .collect(Collectors.toList());
    }
}
