package com.api.login.Documentos.NuevoIngreso.Service;

import com.api.login.Documentos.NuevoIngreso.DTO.DatPersonalNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatPersonalNuevoIngreso;

import java.util.List;

public interface DatPersonalNuevoIngresoService {

    List<DatPersonalNuevoIngresoDTO> GetAllDatPer();

    DatPersonalNuevoIngreso CreateDatPer(DatPersonalNuevoIngresoDTO dto);

    DatPersonalNuevoIngresoDTO updateDatPer(Integer id,DatPersonalNuevoIngresoDTO dto);

    void deleteDatPer(Integer id);

    List<DatPersonalNuevoIngresoDTO> getDatPersonalByNuevoIngreso(Integer id);
}
