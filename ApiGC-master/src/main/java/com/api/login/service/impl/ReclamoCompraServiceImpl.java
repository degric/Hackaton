package com.api.login.service.impl;

import com.api.login.DTO.ReclamoCompraDTO;
import com.api.login.dao.ReclamoCompraDao;
import com.api.login.mapper.ReclamoCompraMapper;
import com.api.login.pojo.ImagenReclamoCompra;
import com.api.login.pojo.ReclamoCompra;
import com.api.login.service.ImagenReclamoCompraService;
import com.api.login.service.ReclamoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReclamoCompraServiceImpl implements ReclamoCompraService {

    @Autowired
    private ReclamoCompraDao dao;

    @Autowired
    private ReclamoCompraMapper mapper;

    @Autowired
    private ImagenReclamoCompraService imagenReclamoCompraService;

    @Override
    public List<ReclamoCompraDTO> GetAll() {
        List<ReclamoCompra> reclamoCompras = dao.findAll();
        return reclamoCompras.stream()
                .map(mapper::ToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReclamoCompraDTO> GetById(Integer id) {
        Optional<ReclamoCompra> optional = dao.findById(id);
        return optional.map(mapper::ToDTO);
    }

    @Override
    public ReclamoCompraDTO Crear(ReclamoCompraDTO dto) {
        ReclamoCompra reclamoCompra = mapper.ToEntity(dto);
        reclamoCompra = dao.save(reclamoCompra);
        return mapper.ToDTO(reclamoCompra);
    }

    @Override
    public ReclamoCompraDTO Actualizar(Integer id, ReclamoCompraDTO dto) {
        Optional<ReclamoCompra> optional = dao.findById(id);
        if (optional.isPresent()){
            ReclamoCompra entity = optional.get();

            entity.setCoDocumento(dto.getCoDocumento());
            entity.setNumeroRevision(dto.getNumeroRevision());
            entity.setFechaEmision(dto.getFechaEmision());
            entity.setFechaRevision(dto.getFechaRevision());
            entity.setFecha(dto.getFecha());
            entity.setProveedor(dto.getProveedor());
            entity.setNomAtiReclamo(dto.getNomAtiReclamo());
            entity.setCasua(dto.getCasua());
            entity.setAccionTomada(dto.getAccionTomada());
            entity.setFechaCierre(dto.getFechaCierre());
            entity.setElaboro(dto.getElaboro());
            entity.setAutorizo(dto.getAutorizo());

            entity = dao.save(entity);
            return mapper.ToDTO(entity);

        }
        return null;
    }

    @Override
    public void Eliminar(Integer id) {

        Optional<ReclamoCompra> optional = dao.findById(id);
        if (optional.isPresent()){

            ReclamoCompra reclamoCompra = optional.get();

            for (ImagenReclamoCompra imagenReclamoCompra : reclamoCompra.getImagenReclamoCompras()){
                imagenReclamoCompraService.delete(imagenReclamoCompra.getIdImagenReclamoCompra());
            }


            dao.deleteById(id);
        }
    }
}
