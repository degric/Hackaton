package com.api.login.Documentos.ControlDocumentosExternos.Repository;

import com.api.login.Documentos.ControlDocumentosExternos.Pojo.TablaControlDocumentosExternos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaControlDocumentosExternosRepository extends JpaRepository<TablaControlDocumentosExternos, Long> {

    List<TablaControlDocumentosExternos> findByControlDocumentosExternosIdControlDocumentosExternos(Long id);
}

