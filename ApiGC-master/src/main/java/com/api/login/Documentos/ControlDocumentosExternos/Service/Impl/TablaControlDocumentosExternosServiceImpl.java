package com.api.login.Documentos.ControlDocumentosExternos.Service.Impl;

import com.api.login.Documentos.ControlDocumentosExternos.Pojo.TablaControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Repository.TablaControlDocumentosExternosRepository;
import com.api.login.Documentos.ControlDocumentosExternos.Service.TablaControlDocumentosExternosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TablaControlDocumentosExternosServiceImpl implements TablaControlDocumentosExternosService {

    @Autowired
    private TablaControlDocumentosExternosRepository tablaControlDocumentosExternosRepository;

    @Override
    public List<TablaControlDocumentosExternos> findAll() {
        return tablaControlDocumentosExternosRepository.findAll();
    }

    @Override
    public TablaControlDocumentosExternos findById(Long id) {
        Optional<TablaControlDocumentosExternos> optional = tablaControlDocumentosExternosRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public TablaControlDocumentosExternos save(TablaControlDocumentosExternos tablaControlDocumentosExternos) {
        return tablaControlDocumentosExternosRepository.save(tablaControlDocumentosExternos);
    }

    @Override
    public TablaControlDocumentosExternos update(Long id, TablaControlDocumentosExternos tablaControlDocumentosExternos) {
        Optional<TablaControlDocumentosExternos> optional = tablaControlDocumentosExternosRepository.findById(id);
        if (optional.isPresent()) {
            tablaControlDocumentosExternos.setIdTablaControlDocumentosExternos(id);
            return tablaControlDocumentosExternosRepository.save(tablaControlDocumentosExternos);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        tablaControlDocumentosExternosRepository.deleteById(id);
    }

    @Override
    public List<TablaControlDocumentosExternos> findByEncabezado(Long id) {
        return tablaControlDocumentosExternosRepository.findByControlDocumentosExternosIdControlDocumentosExternos(id);
    }
}
