package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.AbreProdesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.Dao.AbreProdesoDao;
import com.api.login.Procesos.Mapper.AbreProdesoMapper;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Pojo.AbreProdeso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Service.AbreProdesoService;
import com.api.login.Procesos.Service.EnProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbreProdesoServiceImpl implements AbreProdesoService {
    @Autowired
    private AbreProdesoDao dao;

    @Autowired
    private AbreProdesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Override
    public List<AbreProdesoDTO> getAllAbreProceso() {
        List<AbreProdeso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOAbreProceso)
                .collect(Collectors.toList());
    }

    @Override
    public AbreProdesoDTO createAbreProceso(AbreProdesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);

        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        AbreProdeso abreProceso = mapper.toEntityAbreProceso(dto, enProceso1);
        return mapper.toDTOAbreProceso(dao.save(abreProceso));

    }

    @Override
    public AbreProdesoDTO updateAbreProceso(Long id, AbreProdesoDTO dto) {
        Optional<AbreProdeso> optional = dao.findById(id);
        if (optional.isPresent()) {
            AbreProdeso entity = optional.get();
            entity.setAbreviaciones(dto.getAbreviaciones());
            entity.setDefinicion(dto.getDefinicion());
            EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
            EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
            entity.setEnProceso(enProceso);
            return mapper.toDTOAbreProceso(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteAbreProceso(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<AbreProdesoDTO> findByIdEnProceso(Long id) {
        List<AbreProdeso> optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.stream()
                .map(mapper::toDTOAbreProceso)
                .collect(Collectors.toList());
    }

}
