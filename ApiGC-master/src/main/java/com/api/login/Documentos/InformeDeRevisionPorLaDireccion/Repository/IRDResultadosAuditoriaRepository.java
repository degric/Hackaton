package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDResultadosAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRDResultadosAuditoriaRepository extends JpaRepository<IRDResultadosAuditoria, Long> {
    List<IRDResultadosAuditoria> findByInformeRevisionDireccion_IdInformeRevisionDireccion(Long idInformeRevisionDireccion);
}
