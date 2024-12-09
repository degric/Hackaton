package com.api.login.Documentos.ListadoMaestroDocumentos.Repository;

import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListadoMaestroDocumentosRepository extends JpaRepository<ListadoMaestroDocumentos, Long> {
}
