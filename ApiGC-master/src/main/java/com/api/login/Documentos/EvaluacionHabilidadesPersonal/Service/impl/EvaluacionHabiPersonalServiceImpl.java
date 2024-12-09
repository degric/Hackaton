package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.impl;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.EvaluacionHabiPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Dao.EvaluacionHabiPersonalDao;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Mapper.EvaluacionHabiPersonalMapper;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.EvaluacionHabiPersonal;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.TablaEvaluacionHaPersonal;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.DatosEvaluacionHaPersonalService;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.EvaluacionHabiPersonalService;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.TablaEvaluacionHaPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvaluacionHabiPersonalServiceImpl implements EvaluacionHabiPersonalService {

    @Autowired
    private EvaluacionHabiPersonalDao dao;

    @Autowired
    private EvaluacionHabiPersonalMapper mapper;

    @Autowired
    private DatosEvaluacionHaPersonalService datosEvaluacionHaPersonalService;

    @Autowired
    private TablaEvaluacionHaPersonalService tablaEvaluacionHaPersonalService;

    @Override
    public List<EvaluacionHabiPersonalDTO> getAllEHaPe() {
        List<EvaluacionHabiPersonal> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTOEHaPe)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EvaluacionHabiPersonalDTO> getByIdEHaPe(Long id) {
        Optional<EvaluacionHabiPersonal> dto = dao.findById(id);
        return dto.map(mapper::toDTOEHaPe);
    }

    @Override
    public EvaluacionHabiPersonalDTO createEHaPe(EvaluacionHabiPersonalDTO dto) {
        EvaluacionHabiPersonal entity = mapper.toEntityEHaPe(dto);
        entity = dao.save(entity);
        return mapper.toDTOEHaPe(entity);
    }

    @Override
    public EvaluacionHabiPersonalDTO updateEHaPe(Long id, EvaluacionHabiPersonalDTO dto) {
        Optional<EvaluacionHabiPersonal> optional = dao.findById(id);
        if (optional.isPresent()){
            EvaluacionHabiPersonal entity = optional.get();
            entity.setCoDocumento(dto.getCoDocumento());
            entity.setNoRevision(dto.getNoRevision());
            entity.setFechaEmicion(dto.getFechaEmicion());
            entity.setFechaRevision(dto.getFechaRevision());
            entity = dao.save(entity);
            return mapper.toDTOEHaPe(entity);
        }
        return null;
    }

    @Override
    public void deleteEHaPe(Long id) {
        Optional<EvaluacionHabiPersonal> optional = dao.findById(id);
        if (optional.isPresent()){

            EvaluacionHabiPersonal entity = optional.get();
            if (entity.getDatosEvaluacionHaPersonal() != null){
                datosEvaluacionHaPersonalService.deleteDaEvaPer(entity.getDatosEvaluacionHaPersonal().getIdDatosEvaluacionHaPersonal());
            }
            for (TablaEvaluacionHaPersonal tablaEvaluacionHaPersonal : entity.getTablaEvaluacionHaPersonal()){
                tablaEvaluacionHaPersonalService.deleteDaEvaPer(tablaEvaluacionHaPersonal.getIdTablaEvaluacionHaPersonal());
            }

            dao.deleteById(id);
        }

    }
}
