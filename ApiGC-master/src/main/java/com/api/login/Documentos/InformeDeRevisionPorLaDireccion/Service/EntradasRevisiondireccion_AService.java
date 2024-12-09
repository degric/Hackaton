package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_ADTO;

import java.util.List;

public interface EntradasRevisiondireccion_AService {

    List<EntradasRevisiondireccion_ADTO> findAll();

    EntradasRevisiondireccion_ADTO findById(Long id);

    List<EntradasRevisiondireccion_ADTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    EntradasRevisiondireccion_ADTO save(EntradasRevisiondireccion_ADTO entradasRevisiondireccion_ADTO);

    EntradasRevisiondireccion_ADTO update(Long id, EntradasRevisiondireccion_ADTO entradasRevisiondireccion_ADTO);

    void deleteById(Long id);
}
