package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.DTO.ResponsaProcesoDTO;
import com.api.login.Procesos.Dao.ResponsaProcesoDao;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Mapper.ResponsaProcesoMapper;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.ResponsaProceso;
import com.api.login.Procesos.Service.EnProcesoService;
import com.api.login.Procesos.Service.ResponsaProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResponsaProcesoServiceImpl implements ResponsaProcesoService {

    @Autowired
    private ResponsaProcesoDao dao;

    @Autowired
    private ResponsaProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Override
    public List<ResponsaProcesoDTO> getAll() {
        List<ResponsaProceso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponsaProcesoDTO create(ResponsaProcesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);

        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        ResponsaProceso responsaProceso = mapper.toEntity(dto,enProceso1);
        return mapper.toDTO(dao.save(responsaProceso));
    }

    @Override
    public ResponsaProcesoDTO update(Long id, ResponsaProcesoDTO dto) {
        Optional<ResponsaProceso> optional = dao.findById(id);
        if (optional.isPresent()){
            ResponsaProceso entity = optional.get();
            entity.setResponsable(dto.getResponsable());
            entity.setResponsabilidades(dto.getResponsabilidades());
            EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
            EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
            entity.setEnProceso(enProceso);
            return mapper.toDTO(dao.save(entity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<ResponsaProcesoDTO> findByIdEnProceso(Long id) {
        List<ResponsaProceso> optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}

