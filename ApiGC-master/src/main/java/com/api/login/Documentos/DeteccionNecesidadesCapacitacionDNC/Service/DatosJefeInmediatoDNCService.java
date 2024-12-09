package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosJefeInmediatoDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosJefeInmediatoDNC;

import java.util.List;
import java.util.Optional;

public interface DatosJefeInmediatoDNCService {

    List<DatosJefeInmediatoDNCDTO> findAll();

    DatosJefeInmediatoDNCDTO findById(Long id);

    DatosJefeInmediatoDNCDTO findByDetecionNeCaDNC(Long idDetecionNeCaDNC);

    DatosJefeInmediatoDNCDTO save(DatosJefeInmediatoDNCDTO datosJefeInmediatoDNCDTO);

    DatosJefeInmediatoDNCDTO update(Long id, DatosJefeInmediatoDNCDTO datosJefeInmediatoDNCDTO);

    void deleteById(Long id);
}
