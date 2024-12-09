package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDNoConformidadesAcCorrectivasDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.IRDNoConformidadesAcCorrectivasMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDNoConformidadesAcCorrectivas;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.IRDNoConformidadesAcCorrectivasRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDNoConformidadesAcCorrectivasService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRDNoConformidadesAcCorrectivasServiceImpl implements IRDNoConformidadesAcCorrectivasService {

    @Autowired
    private IRDNoConformidadesAcCorrectivasRepository irdNoConformidadesAcCorrectivasRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private IRDNoConformidadesAcCorrectivasMapper irdNoConformidadesAcCorrectivasMapper;

    @Override
    public List<IRDNoConformidadesAcCorrectivasDTO> findAll() {
        return irdNoConformidadesAcCorrectivasRepository.findAll().stream()
                .map(irdNoConformidadesAcCorrectivasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDNoConformidadesAcCorrectivasDTO findById(Long id) {
        IRDNoConformidadesAcCorrectivas noConformidad = irdNoConformidadesAcCorrectivasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No conformidad no encontrada"));
        return irdNoConformidadesAcCorrectivasMapper.toDTO(noConformidad);
    }

    @Override
    public List<IRDNoConformidadesAcCorrectivasDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<IRDNoConformidadesAcCorrectivas> noConformidades = irdNoConformidadesAcCorrectivasRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return noConformidades.stream()
                .map(irdNoConformidadesAcCorrectivasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDNoConformidadesAcCorrectivasDTO save(IRDNoConformidadesAcCorrectivasDTO irdNoConformidadesAcCorrectivasDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(irdNoConformidadesAcCorrectivasDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        IRDNoConformidadesAcCorrectivas noConformidad = irdNoConformidadesAcCorrectivasMapper.toEntity(irdNoConformidadesAcCorrectivasDTO, informeRevisionDireccion);
        IRDNoConformidadesAcCorrectivas savedNoConformidad = irdNoConformidadesAcCorrectivasRepository.save(noConformidad);
        return irdNoConformidadesAcCorrectivasMapper.toDTO(savedNoConformidad);
    }

    @Override
    public IRDNoConformidadesAcCorrectivasDTO update(Long id, IRDNoConformidadesAcCorrectivasDTO irdNoConformidadesAcCorrectivasDTO) {
        IRDNoConformidadesAcCorrectivas existingNoConformidad = irdNoConformidadesAcCorrectivasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No conformidad no encontrada"));

        existingNoConformidad.setTipo(irdNoConformidadesAcCorrectivasDTO.getTipo());
        existingNoConformidad.setReportadas(irdNoConformidadesAcCorrectivasDTO.getReportadas());
        existingNoConformidad.setEnSeguimiento(irdNoConformidadesAcCorrectivasDTO.getEnSeguimiento());
        existingNoConformidad.setImplementadas(irdNoConformidadesAcCorrectivasDTO.getImplementadas());
        existingNoConformidad.setCerradas(irdNoConformidadesAcCorrectivasDTO.getCerradas());

        IRDNoConformidadesAcCorrectivas updatedNoConformidad = irdNoConformidadesAcCorrectivasRepository.save(existingNoConformidad);
        return irdNoConformidadesAcCorrectivasMapper.toDTO(updatedNoConformidad);
    }

    @Override
    public void deleteById(Long id) {
        irdNoConformidadesAcCorrectivasRepository.deleteById(id);
    }
}
