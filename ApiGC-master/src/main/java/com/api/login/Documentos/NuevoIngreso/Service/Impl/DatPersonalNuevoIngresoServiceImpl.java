package com.api.login.Documentos.NuevoIngreso.Service.Impl;

import com.api.login.Documentos.NuevoIngreso.DTO.DatPersonalNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Dao.DatPersonalNuevoIngresoDao;
import com.api.login.Documentos.NuevoIngreso.Mapper.DatPersonalNuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Mapper.NuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatPersonalNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.DatPersonalNuevoIngresoService;
import com.api.login.Documentos.NuevoIngreso.Service.NuevoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatPersonalNuevoIngresoServiceImpl implements DatPersonalNuevoIngresoService {

    @Autowired
    private DatPersonalNuevoIngresoDao dao;

    @Autowired
    private DatPersonalNuevoIngresoMapper mapper;

    @Autowired
    private NuevoIngresoService nuevoIngresoService;

    @Autowired
    private NuevoIngresoMapper nuevoIngresoMapper;

    @Override
    public List<DatPersonalNuevoIngresoDTO> GetAllDatPer() {
        List<DatPersonalNuevoIngreso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTODatPerNu)
                .collect(Collectors.toList());
    }

    @Override
    public DatPersonalNuevoIngreso CreateDatPer(DatPersonalNuevoIngresoDTO dto) {
        NuevoIngresoDTO nuevoIngresoDTO = nuevoIngresoService.getByIdNuIn(dto.getIdNuevoIngreso()).orElse(null);
        if (nuevoIngresoDTO == null){
            return null;
        }
        NuevoIngreso nuevoIngreso = nuevoIngresoMapper.toEntityNuIn(nuevoIngresoDTO);

        DatPersonalNuevoIngreso datPersonalNuevoIngreso = mapper.toEntityDatPerNu(dto,nuevoIngreso);
        return dao.save(datPersonalNuevoIngreso);
    }

    @Override
    public DatPersonalNuevoIngresoDTO updateDatPer(Integer id, DatPersonalNuevoIngresoDTO dto) {

        Optional<DatPersonalNuevoIngreso> optional = dao.findById(id);
        if (optional.isPresent()){
            DatPersonalNuevoIngreso entity = optional.get();

            entity.setRfc(dto.getRfc());
            entity.setTipoSangre(dto.getTipoSangre());
            entity.setNoTelefono(dto.getNoTelefono());
            entity.setNoPerTelefono(dto.getNoPerTelefono());
            entity.setNoSeguroSocial(dto.getNoSeguroSocial());
            entity.setLiConducir(dto.getLiConducir());
            entity.setNoLicencia(dto.getNoLicencia());
            entity.setEmail(dto.getEmail());
            entity.setNivelEstudios(dto.getNivelEstudios());
            entity.setPasatiempos(dto.getPasatiempos());
            NuevoIngresoDTO nuevoIngresoDTO = nuevoIngresoService.getByIdNuIn(dto.getIdNuevoIngreso()).orElse(null);
            entity.setNuevoIngreso(nuevoIngresoMapper.toEntityNuIn(nuevoIngresoDTO));
            return mapper.toDTODatPerNu(dao.save(entity));
        }

        return null;
    }

    @Override
    public void deleteDatPer(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<DatPersonalNuevoIngresoDTO> getDatPersonalByNuevoIngreso(Integer id) {
        Optional<DatPersonalNuevoIngreso> entity = dao.findByNuevoIngresoIdNuevoIngreso(id);
        return entity.stream()
                .map(mapper::toDTODatPerNu)
                .collect(Collectors.toList());
    }
}
