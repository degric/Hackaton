package com.api.login.Documentos.NuevoIngreso.Service.Impl;

import com.api.login.Documentos.NuevoIngreso.DTO.DatosPersonalesNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Dao.DatosPersonalesNuevoIngresoDao;
import com.api.login.Documentos.NuevoIngreso.Mapper.DatosPersonalesNuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Mapper.NuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatosPersonalesNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.DatosPersonalesNuevoIngresoService;
import com.api.login.Documentos.NuevoIngreso.Service.NuevoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatosPersonalesNuevoIngresoServiceImpl implements DatosPersonalesNuevoIngresoService {

    @Autowired
    private DatosPersonalesNuevoIngresoDao dao;

    @Autowired
    private DatosPersonalesNuevoIngresoMapper mapper;

    @Autowired
    private NuevoIngresoService nuevoIngresoService;

    @Autowired
    private NuevoIngresoMapper nuevoIngresoMapper;

    @Override
    public List<DatosPersonalesNuevoIngresoDTO> GetAllDaPer() {
        List<DatosPersonalesNuevoIngreso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDtoDaPer)
                .collect(Collectors.toList());
    }

    @Override
    public DatosPersonalesNuevoIngreso createDaPer(DatosPersonalesNuevoIngresoDTO dto) {
        NuevoIngresoDTO nuevoIngresoDTO = nuevoIngresoService.getByIdNuIn(dto.getIdNuevoIngreso()).orElse(null);
        if (nuevoIngresoDTO == null){
            return null;
        }
        NuevoIngreso nuevoIngreso = nuevoIngresoMapper.toEntityNuIn(nuevoIngresoDTO);

        DatosPersonalesNuevoIngreso datosPersonalesNuevoIngreso = mapper.toEntityDaPer(dto,nuevoIngreso);
        return dao.save(datosPersonalesNuevoIngreso);
    }

    @Override
    public DatosPersonalesNuevoIngresoDTO updateDaPer(Integer id, DatosPersonalesNuevoIngresoDTO dto) {
        Optional<DatosPersonalesNuevoIngreso> optional = dao.findById(id);
        if (optional.isPresent()){
            DatosPersonalesNuevoIngreso entity = optional.get();

            entity.setNombreEmpleado(dto.getNombreEmpleado());
            entity.setFechaNacimiento(dto.getFechaNacimiento());
            entity.setLugarNacimiento(dto.getLugarNacimiento());
            entity.setEdad(dto.getEdad());
            entity.setEstadoSivil(dto.getEstadoSivil());
            entity.setFechaIngreso(dto.getFechaIngreso());
            entity.setNombreMama(dto.getNombreMama());
            entity.setNombrePapa(dto.getNombrePapa());
            entity.setNuHermanos(dto.getNuHermanos());
            NuevoIngresoDTO nuevoIngresoDTO = nuevoIngresoService.getByIdNuIn(dto.getIdNuevoIngreso()).orElse(null);
            entity.setNuevoIngreso(nuevoIngresoMapper.toEntityNuIn(nuevoIngresoDTO));
            return mapper.toDtoDaPer(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteDaPer(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<DatosPersonalesNuevoIngresoDTO> getDaPerByNuevoIngreso(Integer id) {
        Optional<DatosPersonalesNuevoIngreso> entity = dao.findByNuevoIngresoIdNuevoIngreso(id);
        return entity.stream()
                .map(mapper::toDtoDaPer)
                .collect(Collectors.toList());
    }
}
