package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Repository;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDocTabla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LDDocTablaRepository extends JpaRepository<LDDocTabla, Long> {
    List<LDDocTabla> findByListadoDistribucionDocumentos_IdListadoDistribucionDocumentos(Long idListadoDistribucionDocumentos);
}
