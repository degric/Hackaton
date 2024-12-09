package com.api.login.Documentos.ProgramaAuditoriasInternas.Service.Impl;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ProgramaAuditoriasInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Dao.ProgramaAuditoriasInternasDao;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper.ProgramaAuditoriasInternasMapper;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ObservacionesProAuInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ProgramaAuditoriasInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.TablaProAuInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.ObservacionesProAuInternasService;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.ProgramaAuditoriasInternasService;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.TablaProAuInternasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramaAuditoriasInternasServiceImpl implements ProgramaAuditoriasInternasService {

    @Autowired
    private ProgramaAuditoriasInternasDao dao;

    @Autowired
    private ProgramaAuditoriasInternasMapper mapper;

    @Autowired
    private TablaProAuInternasService tablaProAuInternasService;

    @Autowired
    private ObservacionesProAuInternasService observacionesProAuInternasService;

    @Override
    public List<ProgramaAuditoriasInternasDTO> getAllProAuIn() {
        List<ProgramaAuditoriasInternas> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOProAuIn)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProgramaAuditoriasInternasDTO> getByIdProAuIn(Integer id) {
        Optional<ProgramaAuditoriasInternas> optional = dao.findById(id);
        return optional.map(mapper::toDTOProAuIn);
    }

    @Override
    public ProgramaAuditoriasInternasDTO createProAuIn(ProgramaAuditoriasInternasDTO dto) {
        ProgramaAuditoriasInternas entity = mapper.toEntityProAuIn(dto);
        entity = dao.save(entity);
        return mapper.toDTOProAuIn(entity);
    }

    @Override
    public ProgramaAuditoriasInternasDTO updateProAuIn(Integer id, ProgramaAuditoriasInternasDTO dto) {
        Optional<ProgramaAuditoriasInternas> optional = dao.findById(id);
        if (optional.isPresent()){
            ProgramaAuditoriasInternas entity = optional.get();
            entity.setCoDocumento(dto.getCoDocumento());
            entity.setNoRevision(dto.getNoRevision());
            entity.setFechaEmicion(dto.getFechaEmicion());
            entity.setFechaRevision(dto.getFechaRevision());
            entity.setAnio(dto.getAnio());
            entity = dao.save(entity);
            return mapper.toDTOProAuIn(entity);
        }
        return null;
    }

    @Override
    public void deleteProAuIn(Integer id) {
        Optional<ProgramaAuditoriasInternas> optional = dao.findById(id);
        if (optional.isPresent()){
            ProgramaAuditoriasInternas programaAuditoriasInternas = optional.get();

            for (TablaProAuInternas tablaProAuInternas : programaAuditoriasInternas.getTablaProAuInternas()){
                tablaProAuInternasService.deleteTaProAuIn(tablaProAuInternas.getIdTablaProAuInternas());
            }

           try {
               observacionesProAuInternasService.deleteObProAuIn(programaAuditoriasInternas.getObservacionesProAuInternas().getIdObservacionesProAuInternas());
           }catch (Exception e){

           }


            dao.deleteById(id);
        }

    }
}
