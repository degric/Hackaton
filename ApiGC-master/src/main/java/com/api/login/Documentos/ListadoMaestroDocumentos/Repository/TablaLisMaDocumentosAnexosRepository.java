package com.api.login.Documentos.ListadoMaestroDocumentos.Repository;

import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosAnexos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaLisMaDocumentosAnexosRepository extends JpaRepository<TablaLisMaDocumentosAnexos, Long> {
    List<TablaLisMaDocumentosAnexos> findByListadoMaestroDocumentos_IdListadoMaestroDocumentos(Long idListadoMaestroDocumentos);
}

