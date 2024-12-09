package com.api.login.service.impl;

import com.api.login.DTO.FirmaLisDisDocumentosDTO;
import com.api.login.DTO.LisDisDocumentosDTO;
import com.api.login.dao.FirmaLisDisDocumentosDao;
import com.api.login.mapper.FirmaLisDisDocumentoMapper;
import com.api.login.mapper.LisDisDocumentosMapper;
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
public class FirmaLisDisDocumentosServiceImpl implements FirmaLisDisDocumentosService {

    @Autowired
    private FirmaLisDisDocumentosDao dao;

    @Autowired
    private FirmaLisDisDocumentoMapper Mapper;

    @Autowired
    private LisDisDocumentosService lisDisDocumentosService;

    @Autowired
    private LisDisDocumentosMapper lisDisDocumentosMapper;

    @Override
    public List<FirmaLisDisDocumentosDTO> getAll() {
        List<FirmaLisDisDocumentos> firma = dao.findAll();
        return firma.stream()
                .map(Mapper::ToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FirmaLisDisDocumentos create(FirmaLisDisDocumentosDTO dto) {
        LisDisDocumentosDTO lisDisDocumentosDTO = lisDisDocumentosService.getById(dto.getIdLisDisDocumentos()).orElse(null);
        if (lisDisDocumentosDTO == null){
            return null;
        }
        LisDisDocumentos lisDisDocumentos = lisDisDocumentosMapper.toEntity(lisDisDocumentosDTO);

        FirmaLisDisDocumentos firmaLisDisDocumentos = Mapper.ToEntity(dto,lisDisDocumentos);
        return dao.save(firmaLisDisDocumentos);
    }

    @Override
    public FirmaLisDisDocumentosDTO update(Integer id, FirmaLisDisDocumentosDTO dto) {
        Optional<FirmaLisDisDocumentos> optional = dao.findById(id);
        if(optional.isPresent()){
            FirmaLisDisDocumentos firmaLisDisDocumentos = optional.get();

            firmaLisDisDocumentos.setArea(dto.getArea());
            firmaLisDisDocumentos.setNombre(dto.getNombre());
            firmaLisDisDocumentos.setFirma(dto.getFirma());
            LisDisDocumentosDTO lisOptional = lisDisDocumentosService.getById(dto.getIdLisDisDocumentos()).orElse(null);
            firmaLisDisDocumentos.setLisDisDocumentos(lisDisDocumentosMapper.toEntity(lisOptional));

            return Mapper.ToDTO(dao.save(firmaLisDisDocumentos));
        }
        return null;
    }

    @Override
    public void delete(Integer id) {

        Optional<FirmaLisDisDocumentos> optional = dao.findById(id);
        if (optional.isPresent()){
            dao.deleteById(id);
        }
    }

    @Override
    public List<FirmaLisDisDocumentosDTO> getFirmaLisDisById(Integer id) {
        List<FirmaLisDisDocumentos> firmaLisDisDocumentos = dao.findByLisDisDocumentosIdLisDisDocumentos(id);
        return firmaLisDisDocumentos.stream()
                .map(Mapper::ToDTO)
                .collect(Collectors.toList());
    }
}
