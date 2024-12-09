package com.api.login.Documentos.ListadoMaestroDocumentos.Repository;

import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosFormatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaLisMaDocumentosFormatosRepository extends JpaRepository<TablaLisMaDocumentosFormatos, Long> {
    List<TablaLisMaDocumentosFormatos> findByListadoMaestroDocumentos_IdListadoMaestroDocumentos(Long idListadoMaestroDocumentos);
}

