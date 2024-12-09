package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service.Impl;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeAcMeCoPrTablaDTO;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Mapper.SeAcMeCoPrTablaMapper;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeAcMeCoPrTabla;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeguiAccioMejoCorrePrev;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Repository.SeAcMeCoPrTablaRepository;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Repository.SeguiAccioMejoCorrePrevRepository;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service.SeAcMeCoPrTablaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeAcMeCoPrTablaServiceImpl implements SeAcMeCoPrTablaService {

    @Autowired
    private SeAcMeCoPrTablaRepository seAcMeCoPrTablaRepository;

    @Autowired
    private SeguiAccioMejoCorrePrevRepository seguiAccioMejoCorrePrevRepository;

    @Autowired
    private SeAcMeCoPrTablaMapper seAcMeCoPrTablaMapper;

    @Override
    public List<SeAcMeCoPrTablaDTO> findAll() {
        return seAcMeCoPrTablaRepository.findAll().stream()
                .map(seAcMeCoPrTablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeAcMeCoPrTablaDTO findById(Long id) {
        SeAcMeCoPrTabla tabla = seAcMeCoPrTablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Registro no encontrado"));
        return seAcMeCoPrTablaMapper.toDTO(tabla);
    }

    @Override
    public List<SeAcMeCoPrTablaDTO> findBySeguiAccioMejoCorrePrev(Long idSeguiAccioMejoCorrePrev) {
        List<SeAcMeCoPrTabla> tablas = seAcMeCoPrTablaRepository
                .findBySeguiAccioMejoCorrePrev_IdSeguiAccioMejoCorrePrev(idSeguiAccioMejoCorrePrev);
        return tablas.stream()
                .map(seAcMeCoPrTablaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeAcMeCoPrTablaDTO save(SeAcMeCoPrTablaDTO seAcMeCoPrTablaDTO) {
        SeguiAccioMejoCorrePrev seguiAccioMejoCorrePrev = seguiAccioMejoCorrePrevRepository
                .findById(seAcMeCoPrTablaDTO.getIdSeguiAccioMejoCorrePrev())
                .orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));

        SeAcMeCoPrTabla tabla = seAcMeCoPrTablaMapper.toEntity(seAcMeCoPrTablaDTO, seguiAccioMejoCorrePrev);
        SeAcMeCoPrTabla savedTabla = seAcMeCoPrTablaRepository.save(tabla);
        return seAcMeCoPrTablaMapper.toDTO(savedTabla);
    }

    @Override
    public SeAcMeCoPrTablaDTO update(Long id, SeAcMeCoPrTablaDTO seAcMeCoPrTablaDTO) {
        SeAcMeCoPrTabla existingTabla = seAcMeCoPrTablaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Registro no encontrado"));

        existingTabla.setHallazgo(seAcMeCoPrTablaDTO.getHallazgo());
        existingTabla.setEvidenciasObservadas(seAcMeCoPrTablaDTO.getEvidenciasObservadas());
        existingTabla.setResponsableAreaImplantacion(seAcMeCoPrTablaDTO.getResponsableAreaImplantacion());
        existingTabla.setFechaInicio(seAcMeCoPrTablaDTO.getFechaInicio());
        existingTabla.setFechaTermino(seAcMeCoPrTablaDTO.getFechaTermino());
        existingTabla.setAvance(seAcMeCoPrTablaDTO.getAvance());
        existingTabla.setRevisionValoracion(seAcMeCoPrTablaDTO.getRevisionValoracion());

        SeAcMeCoPrTabla updatedTabla = seAcMeCoPrTablaRepository.save(existingTabla);
        return seAcMeCoPrTablaMapper.toDTO(updatedTabla);
    }

    @Override
    public void deleteById(Long id) {
        seAcMeCoPrTablaRepository.deleteById(id);
    }
}

