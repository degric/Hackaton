package com.api.login.Documentos.ConstanciaInduccion.Repository;

import com.api.login.Documentos.ConstanciaInduccion.Pojo.ColaboradoresConsIndu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradoresConsInduRepository extends JpaRepository<ColaboradoresConsIndu, Long> {
    List<ColaboradoresConsIndu> findByConstanciaInduccion_IdConstanciaInduccion(Long idConstanciaInduccion);
}
