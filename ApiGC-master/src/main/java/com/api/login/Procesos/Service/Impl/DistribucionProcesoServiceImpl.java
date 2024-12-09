package com.api.login.Procesos.Service.Impl;

import com.api.login.ManualDeCalidad.Dao.MachoteDocumentosDao;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import com.api.login.Procesos.DTO.DistribucionProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.Dao.DistribucionProcesoDao;
import com.api.login.Procesos.Mapper.DistribucionProcesoMapper;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Pojo.DistribucionProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Service.DistribucionProcesoService;
import com.api.login.Procesos.Service.EnProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistribucionProcesoServiceImpl implements DistribucionProcesoService {

    @Autowired
    private DistribucionProcesoDao dao;

    @Autowired
    private DistribucionProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @Autowired
    private MachoteDocumentosDao machoteDocumentosDao;

    @Override
    public List<DistribucionProcesoDTO> getAllDistribucion() {
        List<DistribucionProceso> lista = dao.findAll();
        return lista.stream()
                .map(mapper::toDTODistribucion)
                .collect(Collectors.toList());
    }

    @Override
    public DistribucionProcesoDTO createDistribucion(DistribucionProcesoDTO dto) {
        EnProcesoDTO enProceso = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
        if (enProceso == null) {
            return null;
        }
        EnProceso enProceso1 = enProcesoMapper.toEntityEnProceso(enProceso);
        if (dao.findByEnProcesoIdEnProceso(dto.getIdEnProceso()).isPresent()) {
            return null;
        } else{
            DistribucionProceso distribucionProceso = mapper.toEntityDistribucion(dto,enProceso1);

            // Guardado en el machote de Manual de Calidad
            Optional<MachoteDocumentos> optional = machoteDocumentosDao.findByNombreDocumento(enProceso1.getNombreProceso());

            if (optional.isPresent()) {
                MachoteDocumentos existingMachoteDocumentos = optional.get();
                existingMachoteDocumentos.setIdDocumento(enProceso1.getIdEnProceso());
                machoteDocumentosDao.save(existingMachoteDocumentos);
            } else {
                MachoteDocumentos newMachoteDocumentos = new MachoteDocumentos();
                newMachoteDocumentos.setNombreDocumento(enProceso1.getNombreProceso());
                newMachoteDocumentos.setIdDocumento(enProceso1.getIdEnProceso());
                newMachoteDocumentos.setCodigoDocumento(enProceso1.getCoDocumento());
                newMachoteDocumentos.setNivelDocumento(1);
                machoteDocumentosDao.save(newMachoteDocumentos);
            }


            return mapper.toDTODistribucion(dao.save(distribucionProceso));
        }
    }

    @Override
    public DistribucionProcesoDTO updateDistribucion(Long id, DistribucionProcesoDTO dto) {
        Optional<DistribucionProceso> optional = dao.findById(id);
        if (optional.isPresent()){
            DistribucionProceso entity = optional.get();
            entity.setContenido(dto.getContenido());
            EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
            EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
            entity.setEnProceso(enProceso);
            return mapper.toDTODistribucion(dao.save(entity));
        }
        return null;
    }

    @Override
    public void deleteDistribucion(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<DistribucionProcesoDTO> findByIdEnProceso(Long id) {
        Optional<DistribucionProceso> optional = dao.findByEnProcesoIdEnProceso(id);
        return optional.map(mapper::toDTODistribucion);
    }
}

