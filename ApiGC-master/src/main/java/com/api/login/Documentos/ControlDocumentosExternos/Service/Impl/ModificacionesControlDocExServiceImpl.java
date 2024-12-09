package com.api.login.Documentos.ControlDocumentosExternos.Service.Impl;

import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ModificacionesControlDocEx;
import com.api.login.Documentos.ControlDocumentosExternos.Repository.ModificacionesControlDocExRepository;
import com.api.login.Documentos.ControlDocumentosExternos.Service.ModificacionesControlDocExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ModificacionesControlDocExServiceImpl implements ModificacionesControlDocExService {

    @Autowired
    private ModificacionesControlDocExRepository modificacionesControlDocExRepository;

    @Override
    public List<ModificacionesControlDocEx> findAll() {
        return modificacionesControlDocExRepository.findAll();
    }

    @Override
    public ModificacionesControlDocEx findById(Long id) {
        Optional<ModificacionesControlDocEx> optional = modificacionesControlDocExRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<ModificacionesControlDocEx> findByEncabezado(Long id) {
        return modificacionesControlDocExRepository.findByControlDocumentosExternosIdControlDocumentosExternos(id);
    }

    @Override
    public ModificacionesControlDocEx save(ModificacionesControlDocEx modificacionesControlDocEx) {
        return modificacionesControlDocExRepository.save(modificacionesControlDocEx);
    }

    @Override
    public ModificacionesControlDocEx update(Long id, ModificacionesControlDocEx modificacionesControlDocEx) {
        Optional<ModificacionesControlDocEx> optional = modificacionesControlDocExRepository.findById(id);
        if (optional.isPresent()) {
            modificacionesControlDocEx.setIdModificacionesControlDocEx(id);
            return modificacionesControlDocExRepository.save(modificacionesControlDocEx);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        modificacionesControlDocExRepository.deleteById(id);
    }
}

