package com.api.login.Documentos.SolicitudCotizacion.Service.Impl;

import com.api.login.Documentos.SolicitudCotizacion.DTO.SolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.Mapper.SolicitudCotizacionMapper;
import com.api.login.Documentos.SolicitudCotizacion.Service.CondicionesSolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.Service.DatosSolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.Service.SolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.dao.SolicitudCotizacionDao;
import com.api.login.Documentos.SolicitudCotizacion.pojo.SolicitudCotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolicitudCotizacionServiceImpl implements SolicitudCotizacionService {

    @Autowired
    private SolicitudCotizacionDao dao;

    @Autowired
    private SolicitudCotizacionMapper mapper;

    @Autowired
    private CondicionesSolicitudCotizacionService condicionesSolicitudCotizacionService;

    @Autowired
    private DatosSolicitudCotizacionService datosSolicitudCotizacionService;

    @Override
    public List<SolicitudCotizacionDTO> getAllSoCoo() {
        List<SolicitudCotizacion> soli = dao.findAll();
        return soli.stream()
                .map(mapper::toDTOSoCo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SolicitudCotizacionDTO> getSoCo(Integer id) {
        Optional<SolicitudCotizacion> optional = dao.findById(id);
        return optional.map(mapper::toDTOSoCo);
    }

    @Override
    public SolicitudCotizacionDTO createSoCo(SolicitudCotizacionDTO DTO) {
        SolicitudCotizacion solicitudCotizacion = mapper.toEntitySoCo(DTO);
        solicitudCotizacion = dao.save(solicitudCotizacion);
        return mapper.toDTOSoCo(solicitudCotizacion);
    }

    @Override
    public SolicitudCotizacionDTO updateSoCo(Integer id, SolicitudCotizacionDTO DTO) {
        Optional<SolicitudCotizacion> optional = dao.findById(id);
        if (optional.isPresent()){
            SolicitudCotizacion entity = optional.get();

            entity.setCoDocumento(DTO.getCoDocumento());
            entity.setNoRevision(DTO.getNoRevision());
            entity.setFechaEmicion(DTO.getFechaEmicion());
            entity.setFechaRevision(DTO.getFechaRevision());
            entity.setNomSolicita(DTO.getNomSolicita());
            entity = dao.save( entity);

            return mapper.toDTOSoCo(entity);
        }

        return null;
    }

    @Override
    public void deleteSoCo(Integer id) {
        Optional<SolicitudCotizacion> optional = dao.findById(id);

        if (optional.isPresent()){

            SolicitudCotizacion entity = optional.get();
            condicionesSolicitudCotizacionService.deleteCoSoCo(entity.getCondicionesSolicitudCotizacions().getIdCondicionesSolicitudCotizacion());
            datosSolicitudCotizacionService.deleteDaSoCo(entity.getDatosSolicitudCotizacion().getIdDatosSolicitudCotizacion());

            dao.deleteById(id);
        }

    }
}
