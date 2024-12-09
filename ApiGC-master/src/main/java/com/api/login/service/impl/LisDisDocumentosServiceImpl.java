package com.api.login.service.impl;

import com.api.login.DTO.LisDisDocumentosDTO;
import com.api.login.dao.LisDisDocumentosDao;
import com.api.login.mapper.LisDisDocumentosMapper;
import com.api.login.pojo.DocumentosLisDisDo;
import com.api.login.pojo.FirmaLisDisDocumentos;
import com.api.login.pojo.LisDisDocumentos;
import com.api.login.service.DocumentosLisDisDoService;
import com.api.login.service.FirmaLisDisDocumentosService;
import com.api.login.service.LisDisDocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LisDisDocumentosServiceImpl implements LisDisDocumentosService {

    @Autowired
    private LisDisDocumentosDao dao;

    @Autowired
    private LisDisDocumentosMapper mapper;

    @Autowired
    private DocumentosLisDisDoService documentosLisDisDoService;

    @Autowired
    private FirmaLisDisDocumentosService firmaLisDisDocumentosService;


    @Override
    public List<LisDisDocumentosDTO> getAll() {
        List<LisDisDocumentos> lisDisDocumentos = dao.findAll();
        return lisDisDocumentos.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LisDisDocumentosDTO> getById(Integer id) {
        Optional<LisDisDocumentos> optional = dao.findById(id);
        return optional.map(mapper::toDTO);
    }

    @Override
    public LisDisDocumentosDTO create(LisDisDocumentosDTO dto) {
        LisDisDocumentos lisDisDocumentos = mapper.toEntity(dto);
        lisDisDocumentos = dao.save(lisDisDocumentos);
        return mapper.toDTO(lisDisDocumentos);
    }

    @Override
    public LisDisDocumentosDTO update(Integer id, LisDisDocumentosDTO dto) {
        Optional<LisDisDocumentos> optional = dao.findById(id);
        if (optional.isPresent()){

            LisDisDocumentos lisDisDocumentos = optional.get();

            lisDisDocumentos.setFechaEmosion(dto.getFechaEmosion());
            lisDisDocumentos.setFechaRevision(dto.getFechaRevision());
            lisDisDocumentos.setCoDocumentos(dto.getCoDocumentos());
            lisDisDocumentos.setNoRevision(dto.getNoRevision());
            lisDisDocumentos.setStatus(dto.getStatus());
            lisDisDocumentos.setDescripcion(dto.getDescripcion());

            lisDisDocumentos = dao.save(lisDisDocumentos);
            return mapper.toDTO(lisDisDocumentos);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        Optional<LisDisDocumentos> optional = dao.findById(id);
        if (optional.isPresent()){

            LisDisDocumentos lisDisDocumentos = optional.get();

            for (DocumentosLisDisDo documentosLisDisDo: lisDisDocumentos.getDocumentosLisDisDos()){
                documentosLisDisDoService.delete(documentosLisDisDo.getIdDocumentosLisDisDo());
            }

            for (FirmaLisDisDocumentos firmaLisDisDocumentos : lisDisDocumentos.getFirmaLisDisDocumentos()){
                firmaLisDisDocumentosService.delete(firmaLisDisDocumentos.getIdFirmaLisDisDocumentos());
            }


            dao.deleteById(id);
        }
    }
}
