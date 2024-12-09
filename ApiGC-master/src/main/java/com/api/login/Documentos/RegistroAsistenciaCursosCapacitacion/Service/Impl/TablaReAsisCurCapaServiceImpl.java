package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.Impl;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.ReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.TablaReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Dao.TablaReAsisCurCapaDao;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Mapper.ReAsisCurCapaMapper;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Mapper.TablaReAsisCurCapaMapper;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.ReAsisCurCapa;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.TablaReAsisCurCapa;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.ReAsisCurCapaService;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.TablaReAsisCurCapaService;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TablaReAsisCurCapaServiceImpl implements TablaReAsisCurCapaService {

    @Autowired
    private TablaReAsisCurCapaDao dao;

    @Autowired
    private TablaReAsisCurCapaMapper mapper;

    @Autowired
    private ReAsisCurCapaService reAsisCurCapaService;

    @Autowired
    private ReAsisCurCapaMapper reAsisCurCapaMapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosDao;

    @Override
    public List<TablaReAsisCurCapaDTO> getAll() {
        List<TablaReAsisCurCapa> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TablaReAsisCurCapaDTO create(TablaReAsisCurCapaDTO dto) {
        ReAsisCurCapaDTO reAsisCurCapaDTO = reAsisCurCapaService.getById(dto.getIdReAsisCurCapa()).orElse(null);
        if (reAsisCurCapaDTO == null){
            return null;
        }
        ReAsisCurCapa reAsisCurCapa = reAsisCurCapaMapper.toEntityReAs(reAsisCurCapaDTO);

        TablaReAsisCurCapa tablaReAsisCurCapa = mapper.toEntity(dto, reAsisCurCapa);

        // Guardado en el machote de Manual de Calidad
        Optional<MachoteDocumentos> optional = machoteDocumentosDao.findByNombreDocumento("Registro de asistencia de capacitacion");

        if (optional.isPresent()) {
            MachoteDocumentos existingMachoteDocumentos = optional.get();
            existingMachoteDocumentos.setIdDocumento(reAsisCurCapa.getIdReAsisCurCapa());
            machoteDocumentosDao.save(existingMachoteDocumentos);
        } else {
            MachoteDocumentos newMachoteDocumentos = new MachoteDocumentos();
            newMachoteDocumentos.setNombreDocumento("Registro de asistencia de capacitacion");
            newMachoteDocumentos.setIdDocumento(reAsisCurCapa.getIdReAsisCurCapa());
            newMachoteDocumentos.setNivelDocumento(2);
            newMachoteDocumentos.setCodigoDocumento(reAsisCurCapa.getCoDocumento());
            machoteDocumentosDao.save(newMachoteDocumentos);
        }
        return mapper.toDTO(dao.save(tablaReAsisCurCapa));
    }

    @Override
    public TablaReAsisCurCapaDTO update(Long id, TablaReAsisCurCapaDTO dto) {
        Optional<TablaReAsisCurCapa> optional = dao.findById(id);
        if (optional.isPresent()){
            TablaReAsisCurCapa entity = optional.get();
            entity.setNombre(dto.getNombre());
            entity.setPuesto(dto.getPuesto());
            entity.setArea(dto.getArea());
            entity.setFirma(dto.getFirma());
            ReAsisCurCapaDTO reAsisCurCapa = reAsisCurCapaService.getById(dto.getIdReAsisCurCapa()).orElse(null);
            entity.setReAsisCurCapa(reAsisCurCapaMapper.toEntityReAs(reAsisCurCapa));
            return mapper.toDTO(dao.save(entity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<TablaReAsisCurCapaDTO> getById(Long id) {
        List<TablaReAsisCurCapa> entity = dao.findByReAsisCurCapaIdReAsisCurCapa(id);
        return entity.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}

