package com.api.login.Documentos.NuevoIngreso.Service.Impl;

import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Dao.NuevoIngresoDao;
import com.api.login.Documentos.NuevoIngreso.Mapper.NuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.TraAnNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NuevoIngresoServiceImpl implements NuevoIngresoService {

    @Autowired
    private NuevoIngresoDao dao;

    @Autowired
    private NuevoIngresoMapper mapper;

    @Autowired
    private DatosPersonalesNuevoIngresoService datosPersonalesNuevoIngresoService;

    @Autowired
    private DatPersonalNuevoIngresoService datPersonalNuevoIngresoService;

    @Autowired
    private DomicilioNuevoIngresoService domicilioNuevoIngresoService;

    @Autowired
    private TraAnNuevoIngresoService traAnNuevoIngresoService;


    @Override
    public List<NuevoIngresoDTO> getAllNuIn() {
        List<NuevoIngreso> nuevoIngreso = dao.findAll();
        return nuevoIngreso.stream()
                .map(mapper::toDTONuIn)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NuevoIngresoDTO> getByIdNuIn(Integer id) {
        Optional<NuevoIngreso> optional = dao.findById(id);
        return optional.map(mapper::toDTONuIn);
    }

    @Override
    public NuevoIngresoDTO createNuIn(NuevoIngresoDTO dto) {
        NuevoIngreso nuevoIngreso = mapper.toEntityNuIn(dto);
        nuevoIngreso = dao.save(nuevoIngreso);
        return mapper.toDTONuIn(nuevoIngreso);
    }

    @Override
    public NuevoIngresoDTO updateNuIn(Integer id, NuevoIngresoDTO dto) {
        Optional<NuevoIngreso> optional = dao.findById(id);
        if (optional.isPresent()){
            NuevoIngreso entity = optional.get();

            entity.setCoDocumento(dto.getCoDocumento());
            entity.setNoRevision(dto.getNoRevision());
            entity.setFechaEmicion(dto.getFechaEmicion());
            entity.setFechaRevision(dto.getFechaRevision());
            entity = dao.save(entity);
            return mapper.toDTONuIn(entity);
        }
        return null;
    }

    @Override
    public void deleteNuIn(Integer id) {

        Optional<NuevoIngreso> optional = dao.findById(id);
        if (optional.isPresent()){
            NuevoIngreso entity = optional.get();

            try {
                datosPersonalesNuevoIngresoService.deleteDaPer(entity.getDatosPersonalesNuevoIngreso().getIdDatosPersonalesNuevoIngreso());
                datPersonalNuevoIngresoService.deleteDatPer(entity.getDatPersonalNuevoIngreso().getIdDatPersonalNuevoIngreso());
                domicilioNuevoIngresoService.eliminarDoNuIn(entity.getDomicilioNuevoIngreso().getIdDomicilioNuevoIngreso());
            }catch (Exception ignored){

            }
            for (TraAnNuevoIngreso traAnNuevoIngreso : entity.getTraAnNuevoIngresos()){
                traAnNuevoIngresoService.deleteTraNuIn(traAnNuevoIngreso.getIdTraAnNuevoIngreso());
            }
            dao.deleteById(id);
        }
    }
}
