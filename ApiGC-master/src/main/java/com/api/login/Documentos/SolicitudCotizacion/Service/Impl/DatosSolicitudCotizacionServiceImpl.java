package com.api.login.Documentos.SolicitudCotizacion.Service.Impl;

import com.api.login.Documentos.SolicitudCotizacion.DTO.DatosSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.DTO.SolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.Mapper.DatosSolicitudCotizacionMapper;
import com.api.login.Documentos.SolicitudCotizacion.Mapper.SolicitudCotizacionMapper;
import com.api.login.Documentos.SolicitudCotizacion.Service.DatosSolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.Service.SolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.dao.DatosSolicitudCotizacionDao;
import com.api.login.Documentos.SolicitudCotizacion.pojo.DatosSolicitudCotizacion;
import com.api.login.Documentos.SolicitudCotizacion.pojo.SolicitudCotizacion;
import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatosSolicitudCotizacionServiceImpl implements DatosSolicitudCotizacionService {

    @Autowired
    private DatosSolicitudCotizacionDao dao;

    @Autowired
    private DatosSolicitudCotizacionMapper mapper;

    @Autowired
    private SolicitudCotizacionService solicitudCotizacionService;

    @Autowired
    private SolicitudCotizacionMapper solicitudCotizacionMapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosDao;

    @Override
    public List<DatosSolicitudCotizacionDTO> GetAllDaSoCo() {
        List<DatosSolicitudCotizacion> datos = dao.findAll();
        return datos.stream()
                .map(mapper::toDTODatosSoCo)
                .collect(Collectors.toList());
    }

    @Override
    public DatosSolicitudCotizacion createDaSoCo(DatosSolicitudCotizacionDTO dto) {

        SolicitudCotizacionDTO solicitudCotizacionDTO = solicitudCotizacionService.getSoCo(dto.getIdSolicitudCotizacion()).orElse(null);
        if (solicitudCotizacionDTO == null){
            return null;
        }
        SolicitudCotizacion solicitudCotizacion = solicitudCotizacionMapper.toEntitySoCo(solicitudCotizacionDTO);

        DatosSolicitudCotizacion datosSolicitudCotizacion = mapper.toEntitySoCo(dto,solicitudCotizacion);

        // Guardado en el machote de Manual de Calidad
        Optional<MachoteDocumentos> optional = machoteDocumentosDao.findByNombreDocumento("Solicitud de cotización");

        if (optional.isPresent()) {
            MachoteDocumentos existingMachoteDocumentos = optional.get();
            existingMachoteDocumentos.setIdDocumento(solicitudCotizacion.getIdSolicitudCotizacion().longValue());
            machoteDocumentosDao.save(existingMachoteDocumentos);
        } else {
            MachoteDocumentos newMachoteDocumentos = new MachoteDocumentos();
            newMachoteDocumentos.setNombreDocumento("Solicitud de cotización");
            newMachoteDocumentos.setIdDocumento(solicitudCotizacion.getIdSolicitudCotizacion().longValue());
            newMachoteDocumentos.setNivelDocumento(2);
            newMachoteDocumentos.setCodigoDocumento(solicitudCotizacion.getCoDocumento());
            machoteDocumentosDao.save(newMachoteDocumentos);
        }
        return dao.save(datosSolicitudCotizacion);
    }

    @Override
    public DatosSolicitudCotizacionDTO updateDaSoCo(Integer id, DatosSolicitudCotizacionDTO dto) {
        Optional<DatosSolicitudCotizacion> optional = dao.findById(id);
        if (optional.isPresent()){
            DatosSolicitudCotizacion entity = optional.get();
            entity.setMunicipio(dto.getMunicipio());
            entity.setEstado(dto.getEstado());
            entity.setFecha(dto.getFecha());
            entity.setSolicitud(dto.getSolicitud());
            entity.setNombre(dto.getNombre());
            entity.setDireccion(dto.getDireccion());
            entity.setTelefono(dto.getTelefono());
            entity.setCelular(dto.getCelular());
            entity.setNombreAtencion(dto.getNombreAtencion());
            entity.setPuesto(dto.getPuesto());
            entity.setCorreo(dto.getCorreo());
            entity.setDescripcionSolicitado(dto.getDescripcionSolicitado());

            SolicitudCotizacionDTO soOptional = solicitudCotizacionService.getSoCo(dto.getIdSolicitudCotizacion()).orElse(null);
            entity.setSolicitudCotizacion(solicitudCotizacionMapper.toEntitySoCo(soOptional));

            return mapper.toDTODatosSoCo(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteDaSoCo(Integer id) {

        Optional<DatosSolicitudCotizacion> optional = dao.findById(id);

        if (optional.isPresent()){
            dao.deleteById(id);
        }
    }

    @Override
    public List<DatosSolicitudCotizacionDTO> getDandiSoliCoti(Integer id) {
        Optional<DatosSolicitudCotizacion> entity = dao.findBySolicitudCotizacionIdSolicitudCotizacion(id);
        return entity.stream()
                .map(mapper::toDTODatosSoCo)
                .collect(Collectors.toList());
    }
}
