package com.api.login.Procesos.Service.Impl;

import com.api.login.ManualDeCalidad.DTO.DocumentosReManualCalidadDTO;
import com.api.login.ManualDeCalidad.Dao.DocumentosReManualCalidadDao;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.Dao.ManualCalidadDao;
import com.api.login.ManualDeCalidad.Mapper.DocumentosReManualCalidadMapper;
import com.api.login.ManualDeCalidad.Service.DocumentosReManualCalidadService;
import com.api.login.ManualDeCalidad.pojo.DocumentosReManualCalidad;
import com.api.login.Procesos.DTO.DocumentosReProcesosDTO;
import com.api.login.Procesos.Dao.DocumentosReProcesosDao;
import com.api.login.Procesos.Dao.EnProcesoDao;
import com.api.login.Procesos.Mapper.DocumentosReProcesosMapper;
import com.api.login.Procesos.Pojo.DocumentosReProcesos;
import com.api.login.Procesos.Service.DocumentosReProcesosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DocumentosReProcesosServiceImpl implements DocumentosReProcesosService {

    @Autowired
    private DocumentosReProcesosDao repository;

    @Autowired
    private DocumentosReProcesosMapper mapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosRepository;

    @Autowired
    private EnProcesoDao enProcesoDao;

    @Override
    public DocumentosReProcesosDTO create(DocumentosReProcesosDTO dto) {
        DocumentosReProcesos entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public DocumentosReProcesosDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("DocumentosReprocesos not found"));
    }

    @Override
    public List<DocumentosReProcesosDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentosReProcesosDTO update(Long id, DocumentosReProcesosDTO dto) {
        DocumentosReProcesos entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DocumentosReManualCalidad not found"));

        entity.setNombrePunto(dto.getNombrePunto());
        entity.setNivelPunto(dto.getNivelPunto());
        entity.setIdSubpunto(dto.getIdSubpunto());

        entity.setEnProceso(enProcesoDao.findById(dto.getIdEnProceso())
                .orElseThrow(() -> new RuntimeException("Proceso not found")));

        entity.setMachoteDocumentos(machoteDocumentosRepository.findById(dto.getIdMachoteDocumentos())
                .orElseThrow(() -> new RuntimeException("MachoteDocumentos not found")));

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DocumentosReProcesosDTO> getIdproceso(Long idManual) {
        return repository.findByEnProcesoIdEnProceso(idManual).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentosReProcesosDTO> getByNivel(Long nivel, Long idSubPunto) {

        List<DocumentosReProcesos> lista = repository.findByNivelPunto(nivel);

        List<DocumentosReProcesosDTO> resultado = new ArrayList<>();
        for (DocumentosReProcesos documentosReProcesos : lista){
            if (documentosReProcesos.getIdSubpunto().equals( idSubPunto)){

                resultado.add(mapper.toDTO(documentosReProcesos));
            }

        }


        return resultado;
    }
}


