package com.api.login.Documentos.ListaDeAsistencia.Repository;

import com.api.login.Documentos.ListaDeAsistencia.Pojo.ListaAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaAsistenciaRepository extends JpaRepository<ListaAsistencia, Long> {
}
