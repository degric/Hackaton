package com.api.login.Documentos.ProgramaAuditoriasInternas.Service.Impl;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ObservacionesProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ProgramaAuditoriasInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Dao.ObservacionesProAuInternasDao;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper.ObservacionesProAuInternasMapper;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper.ProgramaAuditoriasInternasMapper;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ObservacionesProAuInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ProgramaAuditoriasInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.ObservacionesProAuInternasService;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.ProgramaAuditoriasInternasService;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObservacionesProAuInternasServiceImpl implements ObservacionesProAuInternasService {

    @Autowired
    private ObservacionesProAuInternasDao dao;

    @Autowired
    private ObservacionesProAuInternasMapper mapper;

    @Autowired
    private ProgramaAuditoriasInternasService programaAuditoriasInternasService;

    @Autowired
    private ProgramaAuditoriasInternasMapper programaAuditoriasInternasMapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosDao;

    @Override
    public List<ObservacionesProAuInternasDTO> getAllObProAuIn() {
        List<ObservacionesProAuInternas> entity = dao.findAll();
        return entity.stream()
                .map(mapper::toDTOObProAuIn)
                .collect(Collectors.toList());
    }

    @Override
    public ObservacionesProAuInternas createObProAuIn(ObservacionesProAuInternasDTO dto) {
        ProgramaAuditoriasInternasDTO programaAuditoriasInternasDTO = programaAuditoriasInternasService.getByIdProAuIn(dto.getIdProgramaAuditoriasInternas()).orElse(null);
        if (programaAuditoriasInternasDTO == null) {
            return null;
        }
        ProgramaAuditoriasInternas programaAuditoriasInternas = programaAuditoriasInternasMapper.toEntityProAuIn(programaAuditoriasInternasDTO);
        ObservacionesProAuInternas observacionesProAuInternas = mapper.toEntityObProAuIn(dto,programaAuditoriasInternas);

        // Guardado en el machote de Manual de Calidad
        Optional<MachoteDocumentos> optional = machoteDocumentosDao.findByNombreDocumento("Programa de Auditorías internas");

        if (optional.isPresent()) {
            MachoteDocumentos existingMachoteDocumentos = optional.get();
            existingMachoteDocumentos.setIdDocumento(programaAuditoriasInternas.getIdProgramaAuditoriasInternas().longValue());
            machoteDocumentosDao.save(existingMachoteDocumentos);
        } else {
            MachoteDocumentos newMachoteDocumentos = new MachoteDocumentos();
            newMachoteDocumentos.setNombreDocumento("Programa de Auditorías internas");
            newMachoteDocumentos.setIdDocumento(programaAuditoriasInternas.getIdProgramaAuditoriasInternas().longValue());
            newMachoteDocumentos.setNivelDocumento(2);
            newMachoteDocumentos.setCodigoDocumento(programaAuditoriasInternas.getCoDocumento());
            machoteDocumentosDao.save(newMachoteDocumentos);
        }
        return dao.save(observacionesProAuInternas);
    }

    @Override
    public ObservacionesProAuInternasDTO updateObProAuIn(Integer id, ObservacionesProAuInternasDTO dto) {
        Optional<ObservacionesProAuInternas> optional = dao.findById(id);
        if (optional.isPresent()){
            ObservacionesProAuInternas entity = optional.get();
            entity.setObservaciones(dto.getObservaciones());
            entity.setElaboro(dto.getElaboro());
            entity.setAutorizo(dto.getAutorizo());
            ProgramaAuditoriasInternasDTO programaAuditoriasInternasDTO = programaAuditoriasInternasService.getByIdProAuIn(dto.getIdProgramaAuditoriasInternas()).orElse(null);
            entity.setProgramaAuditoriasInternas(programaAuditoriasInternasMapper.toEntityProAuIn( programaAuditoriasInternasDTO));

            return mapper.toDTOObProAuIn(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteObProAuIn(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<ObservacionesProAuInternasDTO> getObProAuInByIdProAuIn(Integer id) {
       Optional<ObservacionesProAuInternas>entity = dao.findByProgramaAuditoriasInternasIdProgramaAuditoriasInternas(id);
        return entity.stream()
                .map(mapper::toDTOObProAuIn)
                .collect(Collectors.toList());
    }
}
