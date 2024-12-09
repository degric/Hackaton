package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosGeneralesDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosGeneralesDNC;

import java.util.List;
import java.util.Optional;

public interface DatosGeneralesDNCService {

    List<DatosGeneralesDNCDTO> findAll();

    DatosGeneralesDNCDTO findById(Long id);

    DatosGeneralesDNCDTO findByDetecionNeCaDNC(Long idDetecionNeCaDNC);

    DatosGeneralesDNCDTO save(DatosGeneralesDNCDTO datosGeneralesDNCDTO);

    DatosGeneralesDNCDTO update(Long id, DatosGeneralesDNCDTO datosGeneralesDNCDTO);

    void deleteById(Long id);
}

