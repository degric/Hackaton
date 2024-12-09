package com.api.login.Documentos.ControlDocumentosExternos.Repository;

import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ModificacionesControlDocEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModificacionesControlDocExRepository extends JpaRepository<ModificacionesControlDocEx, Long> {
    List<ModificacionesControlDocEx> findByControlDocumentosExternosIdControlDocumentosExternos(Long id);
}

