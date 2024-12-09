package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_CDTO;

import java.util.List;

public interface EntradasRevisiondireccion_CService {

    List<EntradasRevisiondireccion_CDTO> findAll();

    EntradasRevisiondireccion_CDTO findById(Long id);

    List<EntradasRevisiondireccion_CDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    EntradasRevisiondireccion_CDTO save(EntradasRevisiondireccion_CDTO entradasRevisiondireccion_CDTO);

    EntradasRevisiondireccion_CDTO update(Long id, EntradasRevisiondireccion_CDTO entradasRevisiondireccion_CDTO);

    void deleteById(Long id);
}

