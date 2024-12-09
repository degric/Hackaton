package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.DesarrolloProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.Dao.DesarrolloProcesoDao;
import com.api.login.Procesos.Dao.SubClausulasProcesoDao;
import com.api.login.Procesos.Mapper.DesarrolloProcesoMapper;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Pojo.DesarrolloProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Service.DesarrolloProcesoService;
import com.api.login.Procesos.Service.EnProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DesarrolloProcesoServiceImpl implements DesarrolloProcesoService {

    @Autowired
    private DesarrolloProcesoDao dao;

    @Autowired
    private DesarrolloProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Autowired
    private SubClausulasProcesoDao subClausulasProcesoDao;

    @Override
    public List<DesarrolloProcesoDTO> getAllDesarrolloProceso() {
        List<DesarrolloProceso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTODesarrolloProceso)
                .collect(Collectors.toList());
    }

    @Override
    public DesarrolloProceso findById(Long id) {
        Optional<DesarrolloProceso> optional = dao.findById(id);
        return optional.orElse(null);
    }

    @Override
    public DesarrolloProcesoDTO createDesarrolloProceso(DesarrolloProcesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);

        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        DesarrolloProceso desarrolloProceso = mapper.toEntityDesarrolloProceso(dto, enProceso1);
        return mapper.toDTODesarrolloProceso(dao.save(desarrolloProceso));
    }

    @Override
    public DesarrolloProceso updateDesarrolloProceso(Long id, DesarrolloProceso dto) {
        Optional<DesarrolloProceso> optional = dao.findById(id);
        if (optional.isPresent()){
            dto.setSubClausulas(subClausulasProcesoDao.findByDesarrolloProcesoIdDesarrolloProceso(id));
            dto.setIdDesarrolloProceso(id);
            return dao.save(dto);
        }else {
            return null;
        }
    }

    @Override
    public void deleteDesarrolloProceso(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<DesarrolloProcesoDTO> findByIdEnProceso(Long id) {
        List<DesarrolloProceso> optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.stream()
                .map(mapper::toDTODesarrolloProceso)
                .collect(Collectors.toList());
    }
}

