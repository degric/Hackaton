package com.api.login.Documentos.ListadoMaestroDocumentos.Repository;

import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosProcesos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaLisMaDocumentosProcesosRepository extends JpaRepository<TablaLisMaDocumentosProcesos, Long> {
    List<TablaLisMaDocumentosProcesos> findByListadoMaestroDocumentos_IdListadoMaestroDocumentos(Long idListadoMaestroDocumentos);
}



