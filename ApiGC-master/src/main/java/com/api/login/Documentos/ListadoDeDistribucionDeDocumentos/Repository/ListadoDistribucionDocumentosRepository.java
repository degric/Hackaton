package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Repository;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.ListadoDistribucionDocumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListadoDistribucionDocumentosRepository extends JpaRepository<ListadoDistribucionDocumentos, Long> {
}

