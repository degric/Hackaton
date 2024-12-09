package com.api.login.Documentos.ListaDeAsistencia.Repository;

import com.api.login.Documentos.ListaDeAsistencia.Pojo.TablaListaAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaListaAsistenciaRepository extends JpaRepository<TablaListaAsistencia, Long> {
    List<TablaListaAsistencia> findByListaAsistencia_IdListaAsistencia(Long idListaAsistencia);
}

