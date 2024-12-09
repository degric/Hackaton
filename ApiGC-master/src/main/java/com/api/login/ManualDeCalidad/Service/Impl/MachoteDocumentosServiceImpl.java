package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.DTO.MachoteDocumentosDTO;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.Mapper.MachoteDocumentosMapper;
import com.api.login.ManualDeCalidad.Service.MachoteDocumentosService;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MachoteDocumentosServiceImpl implements MachoteDocumentosService {

    @Autowired
    private MachoteDocumentosDao repository;

    @Autowired
    private MachoteDocumentosMapper mapper;

    @Override
    public MachoteDocumentosDTO getMachoteDocumentosById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("MachoteDocumentos not found"));
    }

    @Override
    public List<MachoteDocumentosDTO> getAllMachoteDocumentos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MachoteDocumentosDTO> getByNivel(Long nivel) {
        return repository.findByNivelDocumento(nivel)
                .stream().map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}

