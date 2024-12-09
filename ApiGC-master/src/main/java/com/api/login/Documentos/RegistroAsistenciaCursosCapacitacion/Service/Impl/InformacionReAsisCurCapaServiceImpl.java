package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.Impl;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.InformacionReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.ReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Dao.InformacionReAsisCurCapaDao;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Mapper.InformacionReAsisCurCapaMapper;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Mapper.ReAsisCurCapaMapper;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.InformacionReAsisCurCapa;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.ReAsisCurCapa;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.InformacionReAsisCurCapaService;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.ReAsisCurCapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InformacionReAsisCurCapaServiceImpl implements InformacionReAsisCurCapaService {

    @Autowired
    private InformacionReAsisCurCapaDao dao;

    @Autowired
    private InformacionReAsisCurCapaMapper mapper;

    @Autowired
    private ReAsisCurCapaService reAsisCurCapaService;

    @Autowired
    private ReAsisCurCapaMapper reAsisCurCapaMapper;

    @Override
    public List<InformacionReAsisCurCapaDTO> getAllInReAs() {
        List<InformacionReAsisCurCapa> entity = dao.findAll();
        return entity.stream()
                .map(mapper::toDTOInReAs)
                .collect(Collectors.toList());
    }

    @Override
    public InformacionReAsisCurCapaDTO createInReAs(InformacionReAsisCurCapaDTO dto) {
        ReAsisCurCapaDTO reAsisCurCapaDTO = reAsisCurCapaService.getById(dto.getIdReAsisCurCapa()).orElse(null);
        if (reAsisCurCapaDTO == null){
            return null;
        }
        ReAsisCurCapa reAsisCurCapa = reAsisCurCapaMapper.toEntityReAs(reAsisCurCapaDTO);
        if (dao.findByReAsisCurCapaIdReAsisCurCapa(dto.getIdReAsisCurCapa()).isPresent()){
            return null;
        }else {
         InformacionReAsisCurCapa informacionReAsisCurCapa = dao.save(mapper.toEntityInReAs(dto,reAsisCurCapa));
         return mapper.toDTOInReAs(informacionReAsisCurCapa);
        }
    }

    @Override
    public InformacionReAsisCurCapaDTO updateInReAs(Long id, InformacionReAsisCurCapaDTO dto) {
        Optional<InformacionReAsisCurCapa> optional = dao.findById(id);
        if (optional.isPresent()){
            InformacionReAsisCurCapa entity = optional.get();

            entity.setFecha(dto.getFecha());
            entity.setNomCurso(dto.getNomCurso());
            entity.setInstructor(dto.getInstructor());
            entity.setDuracion(dto.getDuracion());
            entity.setResponsable(dto.getResponsable());
            ReAsisCurCapaDTO reAsisCurCapaDTO = reAsisCurCapaService.getById(dto.getIdReAsisCurCapa()).orElse(null);
            ReAsisCurCapa reAsisCurCapa = reAsisCurCapaMapper.toEntityReAs(reAsisCurCapaDTO);
            entity.setReAsisCurCapa(reAsisCurCapa);

            return mapper.toDTOInReAs(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteInReAs(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<InformacionReAsisCurCapaDTO> findByIdEncabezado(Long id) {
        Optional<InformacionReAsisCurCapa> optional = dao.findByReAsisCurCapaIdReAsisCurCapa(id);
        return optional.map(mapper::toDTOInReAs);
    }
}
