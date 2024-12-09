package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDAdecuacionRecursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRDAdecuacionRecursosRepository extends JpaRepository<IRDAdecuacionRecursos, Long> {
    List<IRDAdecuacionRecursos> findByInformeRevisionDireccion_IdInformeRevisionDireccion(Long idInformeRevisionDireccion);
}

