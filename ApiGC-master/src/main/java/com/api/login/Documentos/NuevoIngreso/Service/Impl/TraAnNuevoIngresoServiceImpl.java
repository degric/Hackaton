package com.api.login.Documentos.NuevoIngreso.Service.Impl;

import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.DTO.TraAnNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Dao.TraAnNuevoIngresoDao;
import com.api.login.Documentos.NuevoIngreso.Mapper.NuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Mapper.TraAnNuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.TraAnNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.NuevoIngresoService;
import com.api.login.Documentos.NuevoIngreso.Service.TraAnNuevoIngresoService;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TraAnNuevoIngresoServiceImpl implements TraAnNuevoIngresoService {

    @Autowired
    private TraAnNuevoIngresoDao dao;

    @Autowired
    private TraAnNuevoIngresoMapper mapper;

    @Autowired
    private NuevoIngresoService nuevoIngresoService;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosDao;

    @Autowired
    private NuevoIngresoMapper nuevoIngresoMapper;

    @Override
    public List<TraAnNuevoIngresoDTO> getAllTraNuIn() {
        List<TraAnNuevoIngreso> entity = dao.findAll();
        return entity.stream()
                .map(mapper::toDTOTraNuIn)
                .collect(Collectors.toList());
    }

    @Override
    public TraAnNuevoIngreso createTraNuIn(TraAnNuevoIngresoDTO dto) {
        NuevoIngresoDTO nuevoIngresoDTO = nuevoIngresoService.getByIdNuIn(dto.getIdNuevoIngreso()).orElse(null);
        if (nuevoIngresoDTO == null){
            return null;
        }
        NuevoIngreso nuevoIngreso = nuevoIngresoMapper.toEntityNuIn(nuevoIngresoDTO);
        TraAnNuevoIngreso traAnNuevoIngreso = mapper.toEntityTraNuIn(dto,nuevoIngreso);

        // Guardado en el machote de Manual de Calidad
        Optional<MachoteDocumentos> optional = machoteDocumentosDao.findByNombreDocumento("Nuevo ingreso");

        if (optional.isPresent()) {
            MachoteDocumentos existingMachoteDocumentos = optional.get();
            existingMachoteDocumentos.setIdDocumento(nuevoIngreso.getIdNuevoIngreso().longValue());
            machoteDocumentosDao.save(existingMachoteDocumentos);
        } else {
            MachoteDocumentos newMachoteDocumentos = new MachoteDocumentos();
            newMachoteDocumentos.setNombreDocumento("Nuevo ingreso");
            newMachoteDocumentos.setIdDocumento(nuevoIngreso.getIdNuevoIngreso().longValue());
            newMachoteDocumentos.setNivelDocumento(2);
            newMachoteDocumentos.setCodigoDocumento(nuevoIngreso.getCoDocumento());
            machoteDocumentosDao.save(newMachoteDocumentos);
        }

        return dao.save(traAnNuevoIngreso);
    }

    @Override
    public TraAnNuevoIngresoDTO updateTraNuIn(Integer id, TraAnNuevoIngresoDTO dto) {
        Optional<TraAnNuevoIngreso> optional = dao.findById(id);
        if (optional.isPresent()){
            TraAnNuevoIngreso entity = optional.get();

            entity.setFecha(dto.getFecha());
            entity.setLugar(dto.getLugar());
            entity.setFunDesempenadas(dto.getFunDesempenadas());
            NuevoIngresoDTO nuevoIngresoDTO = nuevoIngresoService.getByIdNuIn(dto.getIdNuevoIngreso()).orElse(null);
            entity.setNuevoIngreso(nuevoIngresoMapper.toEntityNuIn(nuevoIngresoDTO));

            return mapper.toDTOTraNuIn(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteTraNuIn(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<TraAnNuevoIngresoDTO> getTraByNuIn(Integer id) {
        List<TraAnNuevoIngreso> entiyt = dao.findByNuevoIngresoIdNuevoIngreso(id);
        return entiyt.stream()
                .map(mapper::toDTOTraNuIn)
                .collect(Collectors.toList());
    }
}
