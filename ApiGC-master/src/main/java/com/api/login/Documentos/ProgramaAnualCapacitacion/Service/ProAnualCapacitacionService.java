package com.api.login.Documentos.ProgramaAnualCapacitacion.Service;

import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.ProAnualCapacitacionDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface ProAnualCapacitacionService {

    List<ProAnualCapacitacionDTO> findAll();

    ProAnualCapacitacionDTO findById(Long id);

    ProAnualCapacitacionDTO save(ProAnualCapacitacionDTO proAnualCapacitacionDTO);

    ProAnualCapacitacionDTO update(Long id, ProAnualCapacitacionDTO proAnualCapacitacionDTO);

    void deleteById(Long id);

    byte[] generarPdf(Long id) throws DocumentException;
}
