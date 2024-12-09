package com.api.login.Documentos.ListaDeAsistencia.Repository;

import com.api.login.Documentos.ListaDeAsistencia.Pojo.DatosListaAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosListaAsistenciaRepository extends JpaRepository<DatosListaAsistencia, Long> {
    Optional<DatosListaAsistencia> findByListaAsistencia_IdListaAsistencia(Long idListaAsistencia);
}
