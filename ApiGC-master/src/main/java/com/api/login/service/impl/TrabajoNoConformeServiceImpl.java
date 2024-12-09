package com.api.login.service.impl;

import com.api.login.DTO.TrabajoNoConformeDTO;
import com.api.login.dao.TrabajoNoConformeDao;
import com.api.login.mapper.TrabajoNoConformeMapper;
import com.api.login.pojo.TrabajoNoConforme;
import com.api.login.service.TrabajoNoConformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrabajoNoConformeServiceImpl implements TrabajoNoConformeService {

    @Autowired
    private TrabajoNoConformeDao dao;

    @Autowired
    private TrabajoNoConformeMapper mapper;

    @Override
    public List<TrabajoNoConformeDTO> getAll() {
        List<TrabajoNoConforme> trabajo = dao.findAll();
        return trabajo.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TrabajoNoConformeDTO create(TrabajoNoConformeDTO trabajoNoConformeDTO) {
        TrabajoNoConforme trabajo = mapper.toEntity(trabajoNoConformeDTO);
        trabajo = dao.save(trabajo);
        return mapper.toDTO(trabajo);
    }

    @Override
    public TrabajoNoConformeDTO update(Integer id, TrabajoNoConformeDTO trabajoNoConformeDTO) {
        Optional<TrabajoNoConforme> optional = dao.findById(id);
        if(optional.isPresent()){
            TrabajoNoConforme trabajo = optional.get();

            trabajo.setFechaEmision(trabajoNoConformeDTO.getFechaEmision());
            trabajo.setFechaRevision(trabajoNoConformeDTO.getFechaRevision());
            trabajo.setNombreEmpresa(trabajoNoConformeDTO.getNombreEmpresa());
            trabajo.setFechaDeNoConformidad(trabajoNoConformeDTO.getFechaDeNoConformidad());
            trabajo.setFechaCierre(trabajoNoConformeDTO.getFechaCierre());
            trabajo.setNoRevision(trabajoNoConformeDTO.getNoRevision());
            trabajo.setCodigoDocumento(trabajoNoConformeDTO.getCodigoDocumento());
            trabajo.setNombre(trabajoNoConformeDTO.getNombre());
            trabajo.setImportancia(trabajoNoConformeDTO.getImportancia());
            trabajo.setDescripcion(trabajoNoConformeDTO.getDescripcion());
            trabajo.setAccionesCorrectivas(trabajoNoConformeDTO.getAccionesCorrectivas());
            trabajo.setInvolucrados(trabajoNoConformeDTO.getInvolucrados());
            trabajo.setSeguimiento(trabajoNoConformeDTO.getSeguimiento());
            trabajo.setConformidadUsuario(trabajoNoConformeDTO.getConformidadUsuario());
            trabajo.setProveedor(trabajoNoConformeDTO.getProveedor());

            trabajo = dao.save(trabajo);
            return mapper.toDTO(trabajo);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        Optional<TrabajoNoConforme> optional = dao.findById(id);
        if (optional.isPresent()){
            dao.deleteById(id);
        }
    }
}
