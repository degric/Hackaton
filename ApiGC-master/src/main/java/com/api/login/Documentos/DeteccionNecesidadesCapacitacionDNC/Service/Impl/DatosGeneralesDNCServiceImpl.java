package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Impl;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosGeneralesDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.DatosGeneralesDNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.DetecionNeCaDNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.DatosGeneralesDNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.DetecionNeCaDNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosGeneralesDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.DatosGeneralesDNCService;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.DetecionNeCaDNCService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatosGeneralesDNCServiceImpl implements DatosGeneralesDNCService {

    @Autowired
    private DatosGeneralesDNCRepository datosRepository;

    @Autowired
    private DetecionNeCaDNCRepository detecionRepository;

    @Autowired
    private DatosGeneralesDNCMapper datosMapper;

    @Override
    public List<DatosGeneralesDNCDTO> findAll() {
        return datosRepository.findAll().stream()
                .map(datosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DatosGeneralesDNCDTO findById(Long id) {
        DatosGeneralesDNC datos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos Generales DNC no encontrados"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosGeneralesDNCDTO findByDetecionNeCaDNC(Long idDetecionNeCaDNC) {
        DatosGeneralesDNC datos = datosRepository.findByDetecionNeCaDNC_IdDetecionNeCaDNC(idDetecionNeCaDNC)
                .orElseThrow(() -> new EntityNotFoundException("Datos Generales DNC no encontrados para la Detección especificada"));
        return datosMapper.toDTO(datos);
    }

    @Override
    public DatosGeneralesDNCDTO save(DatosGeneralesDNCDTO datosGeneralesDNCDTO) {
        DetecionNeCaDNC detecionNeCaDNC = detecionRepository.findById(datosGeneralesDNCDTO.getIdDetecionNeCaDNC())
                .orElseThrow(() -> new EntityNotFoundException("Detección de Necesidades no encontrada"));

        DatosGeneralesDNC datos = datosMapper.toEntity(datosGeneralesDNCDTO, detecionNeCaDNC);
        DatosGeneralesDNC savedDatos = datosRepository.save(datos);
        return datosMapper.toDTO(savedDatos);
    }

    @Override
    public DatosGeneralesDNCDTO update(Long id, DatosGeneralesDNCDTO datosGeneralesDNCDTO) {
        DatosGeneralesDNC existingDatos = datosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Datos Generales DNC no encontrados"));

        existingDatos.setNombre(datosGeneralesDNCDTO.getNombre());
        existingDatos.setPuesto(datosGeneralesDNCDTO.getPuesto());
        existingDatos.setAntiguedadEmpresa(datosGeneralesDNCDTO.getAntiguedadEmpresa());
        existingDatos.setAntiguedadPuesto(datosGeneralesDNCDTO.getAntiguedadPuesto());
        existingDatos.setEscolaridad(datosGeneralesDNCDTO.getEscolaridad());

        DatosGeneralesDNC updatedDatos = datosRepository.save(existingDatos);
        return datosMapper.toDTO(updatedDatos);
    }

    @Override
    public void deleteById(Long id) {
        datosRepository.deleteById(id);
    }
}
