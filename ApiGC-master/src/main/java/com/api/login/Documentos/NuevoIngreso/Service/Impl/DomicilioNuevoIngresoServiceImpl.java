package com.api.login.Documentos.NuevoIngreso.Service.Impl;

import com.api.login.Documentos.NuevoIngreso.DTO.DomicilioNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Dao.DomicilioNuevoIngresoDao;
import com.api.login.Documentos.NuevoIngreso.Mapper.DomicilioNuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Mapper.NuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.DomicilioNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.DomicilioNuevoIngresoService;
import com.api.login.Documentos.NuevoIngreso.Service.NuevoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DomicilioNuevoIngresoServiceImpl implements DomicilioNuevoIngresoService {

    @Autowired
    private DomicilioNuevoIngresoDao dao;

    @Autowired
    private DomicilioNuevoIngresoMapper mapper;

    @Autowired
    private NuevoIngresoService nuevoIngresoService;

    @Autowired
    private NuevoIngresoMapper nuevoIngresoMapper;

    @Override
    public List<DomicilioNuevoIngresoDTO> getAllDoNuIn() {
        List<DomicilioNuevoIngreso> entity= dao.findAll();
        return entity.stream()
                .map(mapper::toDTODoNuIn)
                .collect(Collectors.toList());
    }

    @Override
    public DomicilioNuevoIngreso createDoNuIn(DomicilioNuevoIngresoDTO dto) {
        NuevoIngresoDTO nuevoIngresoDTO = nuevoIngresoService.getByIdNuIn(dto.getIdNuevoIngreso()).orElse(null);
        if (nuevoIngresoDTO == null){
            return null;
        }
        NuevoIngreso nuevoIngreso = nuevoIngresoMapper.toEntityNuIn(nuevoIngresoDTO);
        DomicilioNuevoIngreso domicilioNuevoIngreso = mapper.toEntityDoNuIn(dto,nuevoIngreso);
        return dao.save(domicilioNuevoIngreso);
    }

    @Override
    public DomicilioNuevoIngresoDTO updateDoNuIn(Integer id, DomicilioNuevoIngresoDTO dto) {
        Optional<DomicilioNuevoIngreso> optional = dao.findById(id);
        if (optional.isPresent()){
            DomicilioNuevoIngreso entity = optional.get();

            entity.setCalleNumero(dto.getCalleNumero());
            entity.setColonia(dto.getColonia());
            entity.setLocalidad(dto.getLocalidad());
            entity.setMuinicipio(dto.getMuinicipio());
            entity.setEstado(dto.getEstado());
            entity.setCp(dto.getCp());
            NuevoIngresoDTO nuevoIngresoDTO = nuevoIngresoService.getByIdNuIn(dto.getIdNuevoIngreso()).orElse(null);
            entity.setNuevoIngreso(nuevoIngresoMapper.toEntityNuIn(nuevoIngresoDTO));

            return mapper.toDTODoNuIn(dao.save(entity));
        }
        return null;
    }

    @Override
    public void eliminarDoNuIn(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<DomicilioNuevoIngresoDTO> getByIdNuevoIngreso(Integer id) {
        Optional<DomicilioNuevoIngreso> entity = dao.findByNuevoIngresoIdNuevoIngreso(id);
        return entity.stream()
                .map(mapper::toDTODoNuIn)
                .collect(Collectors.toList());
    }
}
