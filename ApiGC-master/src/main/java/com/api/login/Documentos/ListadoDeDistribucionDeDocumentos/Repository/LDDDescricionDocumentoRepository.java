package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Repository;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDDescricionDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LDDDescricionDocumentoRepository extends JpaRepository<LDDDescricionDocumento, Long> {
    List<LDDDescricionDocumento> findByListadoDistribucionDocumentos_IdListadoDistribucionDocumentos(Long idListadoDistribucionDocumentos);
}

