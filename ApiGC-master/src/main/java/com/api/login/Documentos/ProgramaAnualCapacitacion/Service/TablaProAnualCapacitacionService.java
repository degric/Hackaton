package com.api.login.Documentos.ProgramaAnualCapacitacion.Service;

import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.TablaProAnualCapacitacionDTO;

import java.util.List;

public interface TablaProAnualCapacitacionService {

    List<TablaProAnualCapacitacionDTO> findAll();

    TablaProAnualCapacitacionDTO findById(Long id);

    List<TablaProAnualCapacitacionDTO> findByProAnualCapacitacionId(Long idProAnualCapacitacion);

    TablaProAnualCapacitacionDTO save(TablaProAnualCapacitacionDTO dto);

    TablaProAnualCapacitacionDTO update(Long id, TablaProAnualCapacitacionDTO dto);

    void deleteById(Long id);
}
