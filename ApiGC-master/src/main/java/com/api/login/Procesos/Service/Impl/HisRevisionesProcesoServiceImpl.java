package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.DTO.HisRevisionesProcesoDTO;
import com.api.login.Procesos.Dao.HisRevisionesProcesoDao;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Mapper.HisRevisionesProcesoMapper;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.HisRevisionesProceso;
import com.api.login.Procesos.Service.EnProcesoService;
import com.api.login.Procesos.Service.HisRevisionesProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HisRevisionesProcesoServiceImpl implements HisRevisionesProcesoService {

    @Autowired
    private HisRevisionesProcesoDao dao;

    @Autowired
    private HisRevisionesProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Override
    public List<HisRevisionesProcesoDTO> getAllHisRevisionesProceso() {
        List<HisRevisionesProceso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOHisRevisionesProceso)
                .collect(Collectors.toList());
    }

    @Override
    public HisRevisionesProcesoDTO createHisRevisionesProceso(HisRevisionesProcesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);

        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        HisRevisionesProceso hisRevisionesProceso = mapper.toEntityHisRevisionesProceso(dto, enProceso1);
        return mapper.toDTOHisRevisionesProceso(dao.save(hisRevisionesProceso));

    }

    @Override
    public HisRevisionesProcesoDTO updateHisRevisionesProceso(Long id, HisRevisionesProcesoDTO dto) {
        Optional<HisRevisionesProceso> optional = dao.findById(id);
        if (optional.isPresent()){
            HisRevisionesProceso entity = optional.get();
            entity.setNumeroRevision(dto.getNumeroRevision());
            entity.setFecha(dto.getFecha());
            entity.setSeccionAfectada(dto.getSeccionAfectada());
            entity.setEfectuadoPor(dto.getEfectuadoPor());
            entity.setFechaEjecucion(dto.getFechaEjecucion());
            EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
            EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
            entity.setEnProceso(enProceso);
            return mapper.toDTOHisRevisionesProceso(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteHisRevisionesProceso(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<HisRevisionesProcesoDTO> findByIdEnProceso(Long id) {
        List<HisRevisionesProceso> optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.stream()
                .map(mapper::toDTOHisRevisionesProceso)
                .collect(Collectors.toList());
    }
}

