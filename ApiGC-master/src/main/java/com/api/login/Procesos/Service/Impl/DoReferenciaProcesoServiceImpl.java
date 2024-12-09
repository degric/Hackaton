package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.DoReferenciaProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.Dao.DoReferenciaProcesoDao;
import com.api.login.Procesos.Mapper.DoReferenciaProcesoMapper;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Pojo.DoReferenciaProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Service.DoReferenciaProcesoService;
import com.api.login.Procesos.Service.EnProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoReferenciaProcesoServiceImpl implements DoReferenciaProcesoService {

    @Autowired
    private DoReferenciaProcesoDao dao;

    @Autowired
    private DoReferenciaProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Override
    public List<DoReferenciaProcesoDTO> getAllDoReferencia() {
        List<DoReferenciaProceso> lista = dao.findAll();
        lista.size();
        return lista.stream()
                .map(mapper::toDTODoReferencia)
                .collect(Collectors.toList());
    }

    @Override
    public DoReferenciaProcesoDTO createDoReferencia(DoReferenciaProcesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);

        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        DoReferenciaProceso doReferenciaProceso = mapper.toEntityDoReferencia(dto, enProceso1);
        return mapper.toDTODoReferencia(dao.save(doReferenciaProceso));
    }

    @Override
    public DoReferenciaProcesoDTO updateDoReferencia(Long id, DoReferenciaProcesoDTO dto) {
        Optional<DoReferenciaProceso> optional = dao.findById(id);
        if (optional.isPresent()) {
            DoReferenciaProceso entity = optional.get();
            entity.setCoDocumento(dto.getCoDocumento());
            entity.setNombreDocumento(dto.getNombreDocumento());
            EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
            EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
            entity.setEnProceso(enProceso);
            return mapper.toDTODoReferencia(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteDoReferencia(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<DoReferenciaProcesoDTO> finByIdEnProceso(Long id) {
        List<DoReferenciaProceso> optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.stream()
                .map(mapper::toDTODoReferencia)
                .collect(Collectors.toList());
    }
}

