package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.impl;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.EvaluacionHabiPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.TablaEvaluacionHaPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Dao.TablaEvaluacionHaPersonalDao;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Mapper.EvaluacionHabiPersonalMapper;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Mapper.TablaEvaluacionHaPersonalMapper;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.EvaluacionHabiPersonal;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.TablaEvaluacionHaPersonal;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.EvaluacionHabiPersonalService;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.TablaEvaluacionHaPersonalService;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TablaEvaluacionHaPersonalServiceImpl implements TablaEvaluacionHaPersonalService {
    @Autowired
    private TablaEvaluacionHaPersonalDao dao;

    @Autowired
    private TablaEvaluacionHaPersonalMapper mapper;

    @Autowired
    private EvaluacionHabiPersonalService evaluacionHabiPersonalService;

    @Autowired
    private EvaluacionHabiPersonalMapper evaluacionHabiPersonalMapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosDao;

    @Override
    public List<TablaEvaluacionHaPersonalDTO> getAllDaEvaPer() {
        List<TablaEvaluacionHaPersonal> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTODaEvaPer)
                .collect(Collectors.toList());
    }

    @Override
    public TablaEvaluacionHaPersonalDTO createDaEvaPer(TablaEvaluacionHaPersonalDTO dto) {
        EvaluacionHabiPersonalDTO data = evaluacionHabiPersonalService.getByIdEHaPe(dto.getIdEvaluacionHabiPersonal()).orElse(null);
        if (data == null) {
            return null;
        }
        EvaluacionHabiPersonal data1 = evaluacionHabiPersonalMapper.toEntityEHaPe(data);
        TablaEvaluacionHaPersonal tablaEvaluacionHaPersonal = mapper.toEntityDaEvaPer(dto, data1);

        // Guardado en el machote de Manual de Calidad
        Optional<MachoteDocumentos> optional = machoteDocumentosDao.findByNombreDocumento("Evaluación de habilidades del personal");

        if (optional.isPresent()) {
            MachoteDocumentos existingMachoteDocumentos = optional.get();
            existingMachoteDocumentos.setIdDocumento(data1.getIdEvaluacionHabiPersonal());
            machoteDocumentosDao.save(existingMachoteDocumentos);
        } else {
            MachoteDocumentos newMachoteDocumentos = new MachoteDocumentos();
            newMachoteDocumentos.setNombreDocumento("Evaluación de habilidades del personal");
            newMachoteDocumentos.setIdDocumento(data1.getIdEvaluacionHabiPersonal());
            newMachoteDocumentos.setNivelDocumento(2);
            newMachoteDocumentos.setCodigoDocumento(data1.getCoDocumento());
            machoteDocumentosDao.save(newMachoteDocumentos);
        }
        return mapper.toDTODaEvaPer(dao.save(tablaEvaluacionHaPersonal));
    }

    @Override
    public TablaEvaluacionHaPersonalDTO updateDaEvaPer(Long id, TablaEvaluacionHaPersonalDTO dto) {
        Optional<TablaEvaluacionHaPersonal> optional = dao.findById(id);
        if (optional.isPresent()) {
            TablaEvaluacionHaPersonal entity = optional.get();
            entity.setPuntoEvaluar(dto.getPuntoEvaluar());
            entity.setOpcion(dto.getOpcion());
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
    public List<TablaEvaluacionHaPersonalDTO> findByEncabezado(Long id) {
        List<TablaEvaluacionHaPersonal> optional = dao.findByEvaluacionHabiPersonalIdEvaluacionHabiPersonal(id);
        return optional.stream()
                .map(mapper::toDTODaEvaPer)
                .collect(Collectors.toList());
    }

    @Override
    public Integer promedio(Long id) {
        List<TablaEvaluacionHaPersonal> optional = dao.findByEvaluacionHabiPersonalIdEvaluacionHabiPersonal(id);
        int valordelalista = optional.size();
        int valordecampo = 0;

        for (TablaEvaluacionHaPersonal tablaEvaluacionHaPersonal : optional){
            if ("C".equalsIgnoreCase(tablaEvaluacionHaPersonal.getOpcion())) {
                valordecampo++;
            }
        }

        // Manejar caso donde la lista está vacía
        if (valordelalista == 0) {
            return null;
        }

        // Calcular el porcentaje
        double porcentaje = ((double) valordecampo / valordelalista) * 100;
        return (int) Math.round(porcentaje);
    }
}

