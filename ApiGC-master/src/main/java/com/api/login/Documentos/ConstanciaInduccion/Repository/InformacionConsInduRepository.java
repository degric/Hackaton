package com.api.login.Documentos.ConstanciaInduccion.Repository;

import com.api.login.Documentos.ConstanciaInduccion.Pojo.InformacionConsIndu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformacionConsInduRepository extends JpaRepository<InformacionConsIndu, Long> {
    List<InformacionConsIndu> findByConstanciaInduccion_IdConstanciaInduccion(Long idConstanciaInduccion);
}
