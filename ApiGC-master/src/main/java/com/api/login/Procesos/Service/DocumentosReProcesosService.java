package com.api.login.Procesos.Service;

import com.api.login.ManualDeCalidad.DTO.DocumentosReManualCalidadDTO;
import com.api.login.Procesos.DTO.DocumentosReProcesosDTO;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.plaf.LabelUI;
import java.util.List;

public interface DocumentosReProcesosService {
    DocumentosReProcesosDTO create(DocumentosReProcesosDTO dto);
    DocumentosReProcesosDTO getById(Long id);
    List<DocumentosReProcesosDTO> getAll();
    DocumentosReProcesosDTO update(Long id, DocumentosReProcesosDTO dto);
    void delete(Long id);

    List<DocumentosReProcesosDTO> getIdproceso(Long idManual);

    List<DocumentosReProcesosDTO> getByNivel(Long nivel, Long idSubPunto);
}
