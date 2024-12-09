package com.api.login.Documentos.ControlDocumentosExternos.Service;

import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ModificacionesControlDocEx;

import java.util.List;

public interface ModificacionesControlDocExService {

    List<ModificacionesControlDocEx> findAll();

    ModificacionesControlDocEx findById(Long id);

    List<ModificacionesControlDocEx> findByEncabezado(Long id);

    ModificacionesControlDocEx save(ModificacionesControlDocEx modificacionesControlDocEx);

    ModificacionesControlDocEx update(Long id, ModificacionesControlDocEx modificacionesControlDocEx);

    void deleteById(Long id);
}
