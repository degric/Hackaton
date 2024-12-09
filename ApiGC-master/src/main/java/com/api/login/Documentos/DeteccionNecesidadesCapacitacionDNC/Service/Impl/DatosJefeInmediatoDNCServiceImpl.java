package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Impl;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosJefeInmediatoDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.DatosJefeInmediatoDNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.DetecionNeCaDNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.DatosJefeInmediatoDNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.DetecionNeCaDNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosGeneralesDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosJefeInmediatoDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.DatosJefeInmediatoDNCService;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.DetecionNeCaDNCService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatosJefeInmediatoDNCServiceImpl implements DatosJefeInmediatoDNCService {

    @Autowired
    private DatosJefeInmediatoDNCRepository datosRepository;

    @Autowired
    private DetecionNeCaDNCRepository detecionRepository;

    @Autowired
    private DatosJefeInmediatoDNCMapper datosMapper;

    @Override
    public List<DatosJefeInmediatoDNCDTO> findAll() {
        return datosRepository.findAll().stream()
                .map(datosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DatosJefeInmediatoDNCDTO findById(Long id) {
        DatosJefeInmediatoDNC datos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos del Jefe Inmediato no encontrados"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosJefeInmediatoDNCDTO findByDetecionNeCaDNC(Long idDetecionNeCaDNC) {
        DatosJefeInmediatoDNC datos = datosRepository.findByDetecionNeCaDNC_IdDetecionNeCaDNC(idDetecionNeCaDNC)
                .orElseThrow(() -> new EntityNotFoundException("Datos del Jefe Inmediato no encontrados para la detección especificada"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosJefeInmediatoDNCDTO save(DatosJefeInmediatoDNCDTO datosJefeInmediatoDNCDTO) {
        DetecionNeCaDNC detecionNeCaDNC = detecionRepository.findById(datosJefeInmediatoDNCDTO.getIdDetecionNeCaDNC())
                .orElseThrow(() -> new EntityNotFoundException("Detección de Necesidades no encontrada"));

        DatosJefeInmediatoDNC datos = datosMapper.toEntity(datosJefeInmediatoDNCDTO, detecionNeCaDNC);
        DatosJefeInmediatoDNC savedDatos = datosRepository.save(datos);
        return datosMapper.toDTO(savedDatos);
    }

    @Override
    public DatosJefeInmediatoDNCDTO update(Long id, DatosJefeInmediatoDNCDTO datosJefeInmediatoDNCDTO) {
        DatosJefeInmediatoDNC existingDatos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos del Jefe Inmediato no encontrados"));

        existingDatos.setNombre(datosJefeInmediatoDNCDTO.getNombre());
        existingDatos.setPuesto(datosJefeInmediatoDNCDTO.getPuesto());
        existingDatos.setArea(datosJefeInmediatoDNCDTO.getArea());
        existingDatos.setFecha(datosJefeInmediatoDNCDTO.getFecha());

        DatosJefeInmediatoDNC updatedDatos = datosRepository.save(existingDatos);
        return datosMapper.toDTO(updatedDatos);
    }

    @Override
    public void deleteById(Long id) {
        datosRepository.deleteById(id);
    }
}
