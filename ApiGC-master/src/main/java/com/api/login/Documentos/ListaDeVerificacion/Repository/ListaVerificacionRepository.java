package com.api.login.Documentos.ListaDeVerificacion.Repository;

import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaVerificacionRepository extends JpaRepository<ListaVerificacion, Long> {
}

