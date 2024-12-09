package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.Impl;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDDesemProveExternosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper.IRDDesemProveExternosMapper;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDDesemProveExternos;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.IRDDesemProveExternosRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository.InformeRevisionDireccionRepository;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDDesemProveExternosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRDDesemProveExternosServiceImpl implements IRDDesemProveExternosService {

    @Autowired
    private IRDDesemProveExternosRepository irdDesemProveExternosRepository;

    @Autowired
    private InformeRevisionDireccionRepository informeRevisionDireccionRepository;

    @Autowired
    private IRDDesemProveExternosMapper irdDesemProveExternosMapper;

    @Override
    public List<IRDDesemProveExternosDTO> findAll() {
        return irdDesemProveExternosRepository.findAll().stream()
                .map(irdDesemProveExternosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDDesemProveExternosDTO findById(Long id) {
        IRDDesemProveExternos resultado = irdDesemProveExternosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor externo no encontrado"));
        return irdDesemProveExternosMapper.toDTO(resultado);
    }

    @Override
    public List<IRDDesemProveExternosDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion) {
        List<IRDDesemProveExternos> proveedores = irdDesemProveExternosRepository
                .findByInformeRevisionDireccion_IdInformeRevisionDireccion(idInformeRevisionDireccion);
        return proveedores.stream()
                .map(irdDesemProveExternosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IRDDesemProveExternosDTO save(IRDDesemProveExternosDTO irdDesemProveExternosDTO) {
        InformeRevisionDireccion informeRevisionDireccion = informeRevisionDireccionRepository
                .findById(irdDesemProveExternosDTO.getIdInformeRevisionDireccion())
                .orElseThrow(() -> new EntityNotFoundException("Informe de revisión no encontrado"));

        IRDDesemProveExternos proveedor = irdDesemProveExternosMapper.toEntity(irdDesemProveExternosDTO, informeRevisionDireccion);
        IRDDesemProveExternos savedProveedor = irdDesemProveExternosRepository.save(proveedor);
        return irdDesemProveExternosMapper.toDTO(savedProveedor);
    }

    @Override
    public IRDDesemProveExternosDTO update(Long id, IRDDesemProveExternosDTO irdDesemProveExternosDTO) {
        IRDDesemProveExternos existingProveedor = irdDesemProveExternosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor externo no encontrado"));

        existingProveedor.setProveedor(irdDesemProveExternosDTO.getProveedor());
        existingProveedor.setTiempoEntrega(irdDesemProveExternosDTO.getTiempoEntrega());
        existingProveedor.setPrecio(irdDesemProveExternosDTO.getPrecio());
        existingProveedor.setCalidad(irdDesemProveExternosDTO.getCalidad());
        existingProveedor.setCalificacion(irdDesemProveExternosDTO.getCalificacion());

        IRDDesemProveExternos updatedProveedor = irdDesemProveExternosRepository.save(existingProveedor);
        return irdDesemProveExternosMapper.toDTO(updatedProveedor);
    }

    @Override
    public void deleteById(Long id) {
        irdDesemProveExternosRepository.deleteById(id);
    }
}

