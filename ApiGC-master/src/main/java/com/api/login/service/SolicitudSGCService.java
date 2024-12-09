package com.api.login.service;

import com.api.login.DTO.SolicitudSGCDTO;

import java.util.List;

public interface SolicitudSGCService {
    List<SolicitudSGCDTO> getAll();

    SolicitudSGCDTO create(SolicitudSGCDTO dto);

    SolicitudSGCDTO update(Integer id, SolicitudSGCDTO solicitudSGCDTO);

    void eliminar(Integer id);
}
