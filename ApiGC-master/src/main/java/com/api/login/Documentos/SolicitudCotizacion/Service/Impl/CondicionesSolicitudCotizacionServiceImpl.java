package com.api.login.Documentos.SolicitudCotizacion.Service.Impl;

import com.api.login.Documentos.SolicitudCotizacion.DTO.CondicionesSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.DTO.SolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.Mapper.CondicionesSolicitudCotizacionMapper;
import com.api.login.Documentos.SolicitudCotizacion.Mapper.SolicitudCotizacionMapper;
import com.api.login.Documentos.SolicitudCotizacion.Service.CondicionesSolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.Service.SolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.dao.CondicionesSolicitudCotizacionDao;
import com.api.login.Documentos.SolicitudCotizacion.pojo.CondicionesSolicitudCotizacion;
import com.api.login.Documentos.SolicitudCotizacion.pojo.SolicitudCotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CondicionesSolicitudCotizacionServiceImpl implements CondicionesSolicitudCotizacionService {

    @Autowired
    private CondicionesSolicitudCotizacionDao dao;

    @Autowired
    private CondicionesSolicitudCotizacionMapper mapper;

    @Autowired
    private SolicitudCotizacionService solicitudCotizacionServiceservice;

    @Autowired
    private SolicitudCotizacionMapper solicitudCotizacionMapper;

    @Override
    public List<CondicionesSolicitudCotizacionDTO> GetAllCoSoCo() {
        List<CondicionesSolicitudCotizacion> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDtoCoSoCo)
                .collect(Collectors.toList());
    }

    @Override
    public CondicionesSolicitudCotizacion createCoSoCo(CondicionesSolicitudCotizacionDTO dto) {
        SolicitudCotizacionDTO solicitudCotizacionDTO = solicitudCotizacionServiceservice.getSoCo(dto.getIdSolicitudCotizacion()).orElse(null);
        if (solicitudCotizacionDTO == null){
            return null;
        }
        SolicitudCotizacion solicitudCotizacion = solicitudCotizacionMapper.toEntitySoCo(solicitudCotizacionDTO);
        CondicionesSolicitudCotizacion condicionesSolicitudCotizacion = mapper.toEntityCoSoCo(dto,solicitudCotizacion);
        return dao.save(condicionesSolicitudCotizacion);
    }

    @Override
    public CondicionesSolicitudCotizacionDTO updateCoSoCo(Integer id, CondicionesSolicitudCotizacionDTO dto) {
        Optional<CondicionesSolicitudCotizacion> optional = dao.findById(id);
        if (optional.isPresent()){
            CondicionesSolicitudCotizacion entity = optional.get();

            entity.setReAlceTecnico(dto.getReAlceTecnico());
            entity.setAlDocumental(dto.getAlDocumental());
            entity.setReAlDocumental(dto.getReAlDocumental());
            entity.setTiempoEntrega(dto.getTiempoEntrega());
            entity.setEnCertificados(dto.getEnCertificados());
            entity.setIva(dto.getIva());
            entity.setCondiPago(dto.getCondiPago());
            SolicitudCotizacionDTO   soOptional = solicitudCotizacionServiceservice.getSoCo(dto.getIdSolicitudCotizacion()).orElse(null);
            entity.setSolicitudCotizacion(solicitudCotizacionMapper.toEntitySoCo(soOptional));

            return mapper.toDtoCoSoCo(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteCoSoCo(Integer id) {

        Optional<CondicionesSolicitudCotizacion> optional = dao.findById(id);

        if (optional.isPresent()){
            dao.deleteById(id);
        }
    }

    @Override
    public List<CondicionesSolicitudCotizacionDTO> getCondiSoliCoti(Integer id) {
        Optional<CondicionesSolicitudCotizacion> entity = dao.findBySolicitudCotizacionIdSolicitudCotizacion(id);
        return entity.stream()
                .map(mapper::toDtoCoSoCo)
                .collect(Collectors.toList());
    }
}
