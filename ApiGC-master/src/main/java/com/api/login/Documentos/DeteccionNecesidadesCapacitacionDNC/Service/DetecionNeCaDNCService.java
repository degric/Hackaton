package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DetecionNeCaDNCDTO;
import com.lowagie.text.DocumentException;

import java.util.List;
import java.util.Optional;

public interface DetecionNeCaDNCService {

    List<DetecionNeCaDNCDTO> findAll();

    DetecionNeCaDNCDTO findById(Long id);

    DetecionNeCaDNCDTO save(DetecionNeCaDNCDTO detecionNeCaDNCDTO);

    DetecionNeCaDNCDTO update(Long id, DetecionNeCaDNCDTO detecionNeCaDNCDTO);

    void deleteById(Long id);

    byte[] generarPdf(Long id) throws DocumentException;
}
