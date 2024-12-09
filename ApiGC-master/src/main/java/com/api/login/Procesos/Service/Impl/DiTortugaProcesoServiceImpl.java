package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.DiTortugaProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.Dao.DiTortugaProcesoDao;
import com.api.login.Procesos.Mapper.DiTortugaProcesoMapper;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Pojo.DiTortugaProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Service.DiTortugaProcesoService;
import com.api.login.Procesos.Service.EnProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiTortugaProcesoServiceImpl implements DiTortugaProcesoService {

    @Autowired
    private DiTortugaProcesoDao dao;

    @Autowired
    private DiTortugaProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Override
    public List<DiTortugaProcesoDTO> getAllDiTortugaProceso() {
        List<DiTortugaProceso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTODiTortugaProceso)
                .collect(Collectors.toList());
    }

    @Override
    public DiTortugaProcesoDTO createDiTortugaProceso(DiTortugaProcesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);

        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        DiTortugaProceso alcanceProceso = mapper.toEntityDiTortugaProceso(dto,enProceso1);
        return mapper.toDTODiTortugaProceso(dao.save(alcanceProceso));

    }

    @Override
    public DiTortugaProcesoDTO updateDiTortugaProceso(Long id, DiTortugaProcesoDTO dto) {
        Optional<DiTortugaProceso> optional = dao.findById(id);
        if (optional.isPresent()){
            DiTortugaProceso entity = optional.get();
            entity.setDescripcion(dto.getDescripcion());
            entity.setNombreProceso(dto.getNombreProceso());
            EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
            EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
            entity.setEnProceso(enProceso);
            return mapper.toDTODiTortugaProceso(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteDiTortugaProceso(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<DiTortugaProcesoDTO> findByIdEnProceso(Long id) {
        List<DiTortugaProceso> optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.stream()
                .map(mapper::toDTODiTortugaProceso)
                .collect(Collectors.toList());
    }
}

