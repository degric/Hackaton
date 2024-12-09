package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTOSinListas;
import com.api.login.Procesos.Dao.EnProcesoDao;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Pojo.*;
import com.api.login.Procesos.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnProcesoServiceImpl implements EnProcesoService {

    @Autowired
    private EnProcesoDao dao;

    @Autowired
    private EnProcesoMapper mapper;

    //clases para eliminar
    @Autowired
    private ObjetivoProcesoService objetivoProcesoService;
    @Autowired
    private AlcanceProcesoService alcanceProcesoService;
    @Autowired
    private DoReferenciaProcesoService doReferenciaProcesoService;
    @Autowired
    private ResponsaProcesoService responsaProcesoService;
    @Autowired
    private AbreProdesoService abreProdesoService;
    @Autowired
    private DesarrolloProcesoService desarrolloProcesoService;
    @Autowired
    private DiTortugaProcesoService diTortugaProcesoService;
    @Autowired
    private DistribucionProcesoService distribucionProcesoService;
    @Autowired
    private HisRevisionesProcesoService hisRevisionesProcesoService;

    @Override
    public Page<EnProcesoDTOSinListas> getAllEnProceso(Pageable pageable) {
        Page<EnProceso> lista = dao.findAll(pageable);
        return lista.map(mapper::toDTOEnProcesoSinListas);
    }
    @Override
    public Page<EnProcesoDTO> listaPagina(Pageable pageable) {
        Page<EnProceso> lista = dao.findAll(pageable);
        return lista.map(mapper::toDTOEnProceso);
    }
    @Override
    public List<EnProcesoDTO> getAllEnProcesoEntity() {
        List<EnProceso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOEnProceso)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EnProcesoDTO> getByIdEnProceso(Long id) {
        Optional<EnProceso> optional = dao.findById(id);
        return optional.map(mapper::toDTOEnProceso);
    }

    @Override
    public EnProcesoDTO createEnProceso(EnProcesoDTO dto) {
        EnProceso entity = mapper.toEntityEnProceso(dto);
        entity = dao.save(entity);
        return mapper.toDTOEnProceso(entity);
    }

    @Override
    public EnProcesoDTO updateEnProceso(Long id, EnProcesoDTO dto) {
        Optional<EnProceso> optional = dao.findById(id);
        if (optional.isPresent()){
            EnProceso entity = optional.get();

            entity.setFechaElaboracion(dto.getFechaElaboracion());
            entity.setFechaEdicion(dto.getFechaEdicion());
            entity.setNoRevision(dto.getNoRevision());
            entity.setCoDocumento(dto.getCoDocumento());
            entity.setNombreProceso(dto.getNombreProceso());
            entity.setCoPie(dto.getCoPie());

            return mapper.toDTOEnProceso(dao.save(entity));
        }

        return null;
    }

    @Override
    public void deleteEnProceso(Long id) {
        Optional<EnProceso> optional = dao.findById(id);
        if (optional.isPresent()) {
            EnProceso entity = optional.get();
            dao.deleteById(id);
        }
    }

    @Override
    public List<EnProcesoDTO> findbynombre(String nombre) {
        List<EnProceso> lista = dao.findAllByNombreProcesoIgnoreCase(nombre);
        return lista.stream()
                .map(mapper::toDTOEnProceso)
                .collect(Collectors.toList());
    }




}
