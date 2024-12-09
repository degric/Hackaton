package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.Impl;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.ReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Dao.ReAsisCurCapaDao;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Mapper.ReAsisCurCapaMapper;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.ReAsisCurCapa;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.TablaReAsisCurCapa;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.InformacionReAsisCurCapaService;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.ReAsisCurCapaService;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.TablaReAsisCurCapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReAsisCurCapaServiceImpl implements ReAsisCurCapaService {

    @Autowired
    private ReAsisCurCapaDao dao;

    @Autowired
    private ReAsisCurCapaMapper mapper;

    @Autowired
    private InformacionReAsisCurCapaService informacionReAsisCurCapaService;

    @Autowired
    private TablaReAsisCurCapaService tablaReAsisCurCapaService;

    @Override
    public List<ReAsisCurCapaDTO> getAllReAsCur() {
        List<ReAsisCurCapa> entity = dao.findAll();
        return entity.stream()
                .map(mapper::toDTOReAs)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReAsisCurCapaDTO> getById(Long id) {
        Optional<ReAsisCurCapa> optional = dao.findById(id);
        return optional.map(mapper::toDTOReAs);
    }

    @Override
    public ReAsisCurCapaDTO createReAsCur(ReAsisCurCapaDTO dto) {
        ReAsisCurCapa entity = mapper.toEntityReAs(dto);
        entity = dao.save(entity);
        return mapper.toDTOReAs(entity);
    }

    @Override
    public ReAsisCurCapaDTO updateReAsCur(Long id, ReAsisCurCapaDTO dto) {
        Optional<ReAsisCurCapa> optional = dao.findById(id);
        if (optional.isPresent()){
            ReAsisCurCapa entity = optional.get();
            entity.setCoDocumento(dto.getCoDocumento());
            entity.setNoRevision(dto.getNoRevision());
            entity.setFechaEmicion(dto.getFechaEmicion());
            entity.setFechaRevision(dto.getFechaRevision());
            entity = dao.save(entity);
            return mapper.toDTOReAs(entity);
        }
        return null;
    }

    @Override
    public void deleteReAsCur(Long id) {
        Optional<ReAsisCurCapa> optional = dao.findById(id);
        if (optional.isPresent()){

            ReAsisCurCapa entity = optional.get();

            if (entity.getInformacionReAsisCurCapa() != null){
                informacionReAsisCurCapaService.deleteInReAs(entity.getInformacionReAsisCurCapa().getIdInformacionReAsisCurCapa());
            }
            for (TablaReAsisCurCapa tablaReAsisCurCapa : entity.getTablaReAsisCurCapas()){
                tablaReAsisCurCapaService.delete(tablaReAsisCurCapa.getIdTablaReAsisCurCapa());
            }
            dao.deleteById(id);
        }

    }
}
