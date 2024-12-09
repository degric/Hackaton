package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.DTO.ObjetivoProcesoDTO;
import com.api.login.Procesos.Dao.ObjetivoProcesoDao;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Mapper.ObjetivoProcesoMapper;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.ObjetivoProceso;
import com.api.login.Procesos.Service.EnProcesoService;
import com.api.login.Procesos.Service.ObjetivoProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjetivoProcesoServiceImpl implements ObjetivoProcesoService {

    @Autowired
    private ObjetivoProcesoDao dao;

    @Autowired
    private ObjetivoProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Override
    public List<ObjetivoProcesoDTO> getAllObProceso() {
        List<ObjetivoProceso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOObProceso)
                .collect(Collectors.toList());
    }

    @Override
    public ObjetivoProcesoDTO createObProceso(ObjetivoProcesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);

        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        if (dao.findByEnProcesoIdEnProceso(dto.getIdEnProceso()).isPresent()) {
            return null;
        } else {
            ObjetivoProceso objetivoProceso = mapper.toEntityObProceso(dto, enProceso1);
            return mapper.toDTOObProceso(dao.save(objetivoProceso));
        }
    }

    @Override
    public ObjetivoProcesoDTO updateObProceso(Long id, ObjetivoProcesoDTO dto) {
        Optional<ObjetivoProceso> optional = dao.findById(id);
        if (optional.isPresent()){
            ObjetivoProceso entity = optional.get();
            entity.setContenido(dto.getContenido());

            EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
            EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
            entity.setEnProceso(enProceso);

            return mapper.toDTOObProceso(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteObProceso(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<ObjetivoProcesoDTO> findByIdEnProceso(Long id) {
        Optional<ObjetivoProceso>optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.map(mapper::toDTOObProceso);
    }
}
