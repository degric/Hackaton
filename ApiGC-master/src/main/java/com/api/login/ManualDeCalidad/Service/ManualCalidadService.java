package com.api.login.ManualDeCalidad.Service;

import com.api.login.ManualDeCalidad.DTO.ManualCalidadDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import java.util.List;

public interface ManualCalidadService {

    List<ManualCalidad> findAllManualC();

    ManualCalidad findByIdManualC(Long id);

    ManualCalidad copyManualC(Long id);

    ManualCalidad saveManualC(ManualCalidad manualCalidad);

    ManualCalidadDTO updateManualC(Long id, ManualCalidadDTO manualCalidadDTO);

    void deleteByIdManualC(Long id);

    void  eleminartodo();
}

