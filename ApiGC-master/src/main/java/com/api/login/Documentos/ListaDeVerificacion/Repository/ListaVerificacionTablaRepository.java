package com.api.login.Documentos.ListaDeVerificacion.Repository;

import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacionTabla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaVerificacionTablaRepository extends JpaRepository<ListaVerificacionTabla, Long> {
    List<ListaVerificacionTabla> findByListaVerificacion_IdListaVerificacion(Long idListaVerificacion);
}
