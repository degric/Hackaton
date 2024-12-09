package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.AlcanceProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.Dao.AlcanceProcesoDao;
import com.api.login.Procesos.Mapper.AlcanceProcesoMapper;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Pojo.AlcanceProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Service.AlcanceProcesoService;
import com.api.login.Procesos.Service.EnProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlcanceProcesoServiceImpl implements AlcanceProcesoService {

    @Autowired
    private AlcanceProcesoDao dao;

    @Autowired
    private AlcanceProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Override
    public List<AlcanceProcesoDTO> getAllAlProceso() {
        List<AlcanceProceso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOAlProceso)
                .collect(Collectors.toList());
    }

    @Override
    public AlcanceProcesoDTO createAlProceso(AlcanceProcesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);

        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        if (dao.findByEnProcesoIdEnProceso(dto.getIdEnProceso()).isPresent()) {
            return null;
        } else{
            AlcanceProceso alcanceProceso = mapper.toEntityAlProceso(dto,enProceso1);
            return mapper.toDTOAlProceso(dao.save(alcanceProceso));
        }
    }

    @Override
    public AlcanceProcesoDTO updateAlProceso(Long id, AlcanceProcesoDTO dto) {
        Optional<AlcanceProceso> optional = dao.findById(id);
        if (optional.isPresent()){
            AlcanceProceso entity = optional.get();
            entity.setContenido(dto.getContenido());
            EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
            EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
            entity.setEnProceso(enProceso);
            return mapper.toDTOAlProceso(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteAlProceso(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<AlcanceProcesoDTO> finByIdEnProceso(Long id) {
        Optional<AlcanceProceso> optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.map(mapper::toDTOAlProceso);
    }
}
