package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_BDTO;

import java.util.List;

public interface EntradasRevisiondireccion_BService {

    List<EntradasRevisiondireccion_BDTO> findAll();

    EntradasRevisiondireccion_BDTO findById(Long id);

    List<EntradasRevisiondireccion_BDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    EntradasRevisiondireccion_BDTO save(EntradasRevisiondireccion_BDTO entradasRevisiondireccion_BDTO);

    EntradasRevisiondireccion_BDTO update(Long id, EntradasRevisiondireccion_BDTO entradasRevisiondireccion_BDTO);

    void deleteById(Long id);
}
