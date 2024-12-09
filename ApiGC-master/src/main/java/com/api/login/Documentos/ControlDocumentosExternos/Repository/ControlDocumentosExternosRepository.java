package com.api.login.Documentos.ControlDocumentosExternos.Repository;

import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlDocumentosExternosRepository extends JpaRepository<ControlDocumentosExternos, Long> {
}

