package com.api.login.service.impl;

import com.api.login.DTO.DocumentosLisDisDoDTO;
import com.api.login.DTO.LisDisDocumentosDTO;
import com.api.login.dao.DocumentosLisDisDoDao;
import com.api.login.dao.LisDisDocumentosDao;
import com.api.login.mapper.DocumentosLisDisDoMapper;
import com.api.login.mapper.LisDisDocumentosMapper;
import com.api.login.pojo.DocumentosLisDisDo;
import com.api.login.pojo.LisDisDocumentos;
import com.api.login.service.DocumentosLisDisDoService;
import com.api.login.service.LisDisDocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentosLisDisDoServiceImpl implements DocumentosLisDisDoService {

    @Autowired
    private DocumentosLisDisDoDao dao;

    @Autowired
    private LisDisDocumentosDao lisDisDocumentosDao;

    @Autowired
    private DocumentosLisDisDoMapper mapper;

    @Autowired
    private LisDisDocumentosMapper lisDisDocumentosMapper;

    @Autowired
    private LisDisDocumentosService lisDisDocumentosService;

    @Override
    public List<DocumentosLisDisDoDTO> getAll() {
        List<DocumentosLisDisDo> documentos = dao.findAll();
        return documentos.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentosLisDisDo create(DocumentosLisDisDoDTO dto, Integer idLisDis) {
        LisDisDocumentosDTO lisDisDocumentosDTO = lisDisDocumentosService.getById(idLisDis).orElse(null);
        if (lisDisDocumentosDTO == null){
            return null;
        }
        LisDisDocumentos lisDisDocumentos = lisDisDocumentosMapper.toEntity(lisDisDocumentosDTO);

        DocumentosLisDisDo documentosLisDisDo = mapper.toEntity(dto,lisDisDocumentos);
        return dao.save(documentosLisDisDo);
    }

    @Override
    public DocumentosLisDisDoDTO update(Integer id, DocumentosLisDisDoDTO dto) {
        Optional<DocumentosLisDisDo> optional = dao.findById(id);
        if (optional.isPresent()){
            DocumentosLisDisDo documentosLisDisDo = optional.get();

            documentosLisDisDo.setArea(dto.getArea());
            documentosLisDisDo.setCoDocumento(dto.getCoDocumento());
            documentosLisDisDo.setRevision(dto.getRevision());
            documentosLisDisDo.setFechaImplantacion(dto.getFechaImplantacion());

            Optional<LisDisDocumentos> lisOptional = lisDisDocumentosDao.findById(dto.getIdLisDisDocumentos());
            documentosLisDisDo.setLisDisDocumentos(lisOptional.get());

            return mapper.toDTO(dao.save(documentosLisDisDo));
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Optional<DocumentosLisDisDo> optional = dao.findById(id);
        if (optional.isPresent()){
            dao.deleteById(id);
        }

    }

    @Override
    public List<DocumentosLisDisDoDTO> getDocimentosByIdEncabezado(Integer id) {
        List<DocumentosLisDisDo> documentosLisDisDos = dao.findByLisDisDocumentosIdLisDisDocumentos(id);
        return documentosLisDisDos.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
