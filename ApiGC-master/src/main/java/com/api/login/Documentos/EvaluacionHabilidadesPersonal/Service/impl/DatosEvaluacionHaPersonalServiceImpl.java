package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.impl;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.DatosEvaluacionHaPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.EvaluacionHabiPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Dao.DatosEvaluacionHaPersonalDao;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Mapper.DatosEvaluacionHaPersonalMapper;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Mapper.EvaluacionHabiPersonalMapper;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.DatosEvaluacionHaPersonal;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.EvaluacionHabiPersonal;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.DatosEvaluacionHaPersonalService;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.EvaluacionHabiPersonalService;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.TablaEvaluacionHaPersonalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatosEvaluacionHaPersonalServiceImpl implements DatosEvaluacionHaPersonalService {

    @Autowired
    private DatosEvaluacionHaPersonalDao dao;

    @Autowired
    private DatosEvaluacionHaPersonalMapper mapper;

    @Autowired
    private EvaluacionHabiPersonalService evaluacionHabiPersonalService;

    @Autowired
    private EvaluacionHabiPersonalMapper evaluacionHabiPersonalMapper;

    @Autowired
    private TablaEvaluacionHaPersonalService tablaEvaluacionHaPersonalService;

    @Override
    public List<DatosEvaluacionHaPersonalDTO> getAllDaEvaPer() {
        List<DatosEvaluacionHaPersonal> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTODaEvaPer)
                .collect(Collectors.toList());
    }

    @Override
    public DatosEvaluacionHaPersonalDTO createDaEvaPer(DatosEvaluacionHaPersonalDTO dto) {
        EvaluacionHabiPersonalDTO data = evaluacionHabiPersonalService.getByIdEHaPe(dto.getIdEvaluacionHabiPersonal()).orElse(null);

        if (data == null){
            return null;
        }
        EvaluacionHabiPersonal data1 = evaluacionHabiPersonalMapper.toEntityEHaPe(data);
        if (dao.findByEvaluacionHabiPersonalIdEvaluacionHabiPersonal(data.getIdEvaluacionHabiPersonal()).isPresent()){
            return null;
        }else {
            DatosEvaluacionHaPersonal datosEvaluacionHaPersonal = mapper.toEntityDaEvaPer(dto,data1);
            return mapper.toDTODaEvaPer(dao.save(datosEvaluacionHaPersonal));
        }
    }

    @Override
    public DatosEvaluacionHaPersonalDTO updateDaEvaPer(Long id, DatosEvaluacionHaPersonalDTO dto) {
        Optional<DatosEvaluacionHaPersonal> optional = dao.findById(id);
        if (optional.isPresent()){
            DatosEvaluacionHaPersonal entity = optional.get();
            entity.setNombre(dto.getNombre());
            entity.setPuesto(dto.getPuesto());
            entity.setFechaEvaluacion(dto.getFechaEvaluacion());
            entity.setEvaluador(dto.getEvaluador());
            entity.setPromedio(tablaEvaluacionHaPersonalService.promedio(dto.getIdEvaluacionHabiPersonal()));
            EvaluacionHabiPersonalDTO data = evaluacionHabiPersonalService.getByIdEHaPe(dto.getIdEvaluacionHabiPersonal()).orElse(null);
            EvaluacionHabiPersonal evaluacionHabiPersonal = evaluacionHabiPersonalMapper.toEntityEHaPe(data);
            entity.setEvaluacionHabiPersonal(evaluacionHabiPersonal);

            return mapper.toDTODaEvaPer(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteDaEvaPer(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<DatosEvaluacionHaPersonalDTO> findByEncabezado(Long id) {
        Optional<DatosEvaluacionHaPersonal> optional = dao.findByEvaluacionHabiPersonalIdEvaluacionHabiPersonal(id);
        return optional.map(mapper::toDTODaEvaPer);
    }
}
